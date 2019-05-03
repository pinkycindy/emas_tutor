package com.pinkycindy.emas_tutor.modul.login;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.pinkycindy.emas_tutor.data.model.ClassroomItem;
import com.pinkycindy.emas_tutor.data.model.Employee;
import com.pinkycindy.emas_tutor.data.model.KabupatenItem;
import com.pinkycindy.emas_tutor.data.model.KecamatanItem;
import com.pinkycindy.emas_tutor.data.model.KelurahanItem;
import com.pinkycindy.emas_tutor.data.model.PropinsiItem;
import com.pinkycindy.emas_tutor.data.source.local.SessionManager;
import com.pinkycindy.emas_tutor.data.source.remote.ApiConnection;
import com.pinkycindy.emas_tutor.data.source.remote.ApiInterface;
import com.pinkycindy.emas_tutor.modul.alarm.AlarmActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Pinky Cindy
 */
public class LoginPresenter implements LoginContract.presenter {

    private LoginContract.view view;
    SessionManager session ;
    Context con;


    public LoginPresenter(LoginContract.view view, Context con) {

        this.view = view;
        this.con = con;
        session = new SessionManager(con);

    }
    @Override
    public void requestLogin(String username, String pass) {
        view.showProgressbar();



        ApiInterface apiService = ApiConnection.getClient();
        apiService.login(username, pass)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                // Jika login berhasil maka data nama yang ada di response API
                                // akan diparsing ke activity selanjutnya.
                                String name = jsonRESULTS.getJSONObject("data").getString("name");
                                String id = jsonRESULTS.getJSONObject("data").getString("id");
                                String username = jsonRESULTS.getJSONObject("data").getString("username");
                                String email = jsonRESULTS.getJSONObject("data").getString("email");


                                ArrayList<Employee> emp = new ArrayList<Employee>();
                                ArrayList<PropinsiItem> propinsi = new ArrayList<PropinsiItem>();
                                ArrayList<KabupatenItem> kabupaten = new ArrayList<KabupatenItem>();
                                ArrayList<KecamatanItem> kecamatan = new ArrayList<KecamatanItem>();
                                ArrayList<KelurahanItem> kelurahan = new ArrayList<KelurahanItem>();
                                ArrayList<ClassroomItem> classroom = new ArrayList<ClassroomItem>();

                                JSONArray ja = jsonRESULTS.getJSONObject("data").getJSONArray("classroom");
                                int len = ja.length();
                                for(int j=0; j<len; j++)
                                {
                                    JSONObject json = ja.getJSONObject(j);
                                    ClassroomItem modelClass = new ClassroomItem();
                                    modelClass.setId(json.getInt("id"));
                                    modelClass.setName(json.getString("name"));
                                    modelClass.setEmployeeId(json.getInt("employee_id"));
                                    modelClass.setSpotId(json.getInt("spot_id"));
                                    modelClass.setDescription(json.getString("description"));
                                    modelClass.setDayFirst(json.getInt("day_first"));
                                    modelClass.setHourFirst(json.getString("hour_first"));
                                    modelClass.setDaySecond(json.getInt("day_second"));
                                    modelClass.setHourSecond(json.getString("hour_second"));
                                    modelClass.setTypeClass(json.getString("type_class"));
                                    modelClass.setCapacity(json.getInt("capacity"));
                                    classroom.add(modelClass);
                                    Log.d("p",json.getString("id").toString());
                                }


                                Employee model = new Employee();
                                model.setId(jsonRESULTS.getJSONObject("data").getInt("id"));
                                model.setName(jsonRESULTS.getJSONObject("data").getString("name"));
                                model.setPropinsi(propinsi);
                                model.setClassroom(classroom);
                                emp.add(model);
                                Log.d("Berhasil :",name);
                                Log.d("id", emp.toString());

                                session.createLoginSession(id, name, username, email);
                                view.hideProgressbar();

                                Intent intent = new Intent(con, AlarmActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.putExtra("emp", emp);
                                con.startActivity(intent);


                                //Toast.makeText(LoginActivity.this, "Alarm set in " + 15 + " seconds",Toast.LENGTH_LONG).show();


//                                session = new SessionManager(getClass());
//                                session.createLoginSession(id, user, email);
                                //view.respondRequest(id, user, email);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        view.hideProgressbar();
                    }
                });
    }

    private void write(String response) {
        try {

            //getting the whole json object from the response
            JSONObject obj = new JSONObject(response);
//            if(obj.optString("status").equals("true")){

                ArrayList<Employee> retroModelArrayList = new ArrayList<>();
                JSONArray dataArray  = obj.getJSONArray("data");

                for (int i = 0; i < dataArray.length(); i++) {

                    JSONObject dataobj = dataArray.getJSONObject(i);
                    Log.d("id", dataobj.getString("id"));

                }
            view.hideProgressbar();

//            }else {
//                Toast.makeText(MainActivity.this, obj.optString("message")+"", Toast.LENGTH_SHORT).show();
//            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void createSession() {

    }

    @Override
    public void createReminder() {

    }
}
