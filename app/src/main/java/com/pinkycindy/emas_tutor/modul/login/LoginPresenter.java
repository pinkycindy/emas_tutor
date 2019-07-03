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
import com.pinkycindy.emas_tutor.data.source.local.SessionAttendances;
import com.pinkycindy.emas_tutor.data.source.local.SessionManager;
import com.pinkycindy.emas_tutor.data.source.remote.ApiConnection;
import com.pinkycindy.emas_tutor.data.source.remote.ApiInterface;
import com.pinkycindy.emas_tutor.modul.reminder.ReminderActivity;

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
    SessionAttendances sessionAttendances;
    Context con;

    Integer id;
    Integer user_id;
    Integer prop_id;
    Integer kab_id;
    Integer kec_id;
    Integer kel_id;
    String name, address, birthday, phone, gender, email, user, avatar;
    ArrayList<Employee> emp;
    ArrayList<ClassroomItem> classroom;
    ArrayList<PropinsiItem> propinsi;
    ArrayList<KabupatenItem> kabupaten;
    ArrayList<KecamatanItem> kecamatan;
    ArrayList<KelurahanItem> kelurahan;


    public LoginPresenter(LoginContract.view view, Context con) {

        this.view = view;
        this.con = con;
        session = new SessionManager(con);
        sessionAttendances = new SessionAttendances(con);

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

                                emp = new ArrayList<Employee>();
                                propinsi = new ArrayList<PropinsiItem>();
                                kabupaten = new ArrayList<KabupatenItem>();
                                kecamatan = new ArrayList<KecamatanItem>();
                                kelurahan = new ArrayList<KelurahanItem>();
                                classroom = new ArrayList<ClassroomItem>();

                                id = jsonRESULTS.getJSONObject("data").getInt("id");
                                name = jsonRESULTS.getJSONObject("data").getString("name");
                                address = jsonRESULTS.getJSONObject("data").getString("birthday");
                                phone = jsonRESULTS.getJSONObject("data").getString("phone");
                                gender = jsonRESULTS.getJSONObject("data").getString("gender");
                                user_id = jsonRESULTS.getJSONObject("data").getInt("user_id");
                                prop_id = jsonRESULTS.getJSONObject("data").getInt("propinsi_id");
                                kab_id = jsonRESULTS.getJSONObject("data").getInt("kabupaten_id");
                                kec_id = jsonRESULTS.getJSONObject("data").getInt("kecamatan_id");
                                kel_id = jsonRESULTS.getJSONObject("data").getInt("kelurahan_id");
                                user = jsonRESULTS.getJSONObject("data").getString("username");
                                email = jsonRESULTS.getJSONObject("data").getString("email");
                                avatar = jsonRESULTS.getJSONObject("data").getString("avatar");

                                JSONArray jsProp = jsonRESULTS.getJSONObject("data").getJSONArray("propinsi");
                                int len_jsProp = jsProp.length();
                                for (int i=0; i<len_jsProp; i++){
                                    JSONObject jsonProp = jsProp.getJSONObject(i);
                                    PropinsiItem propinsiItem = new PropinsiItem();
                                    propinsiItem.setId(jsonProp.getInt("id"));
                                    propinsiItem.setNama(jsonProp.getString("nama"));
                                    propinsi.add(propinsiItem);

                                }
                                JSONArray jsKab = jsonRESULTS.getJSONObject("data").getJSONArray("kabupaten");
                                int len_jsKab = jsKab.length();
                                for (int i=0; i<len_jsKab; i++){
                                    JSONObject jsonKab = jsKab.getJSONObject(i);
                                    KabupatenItem kabupatenItem = new KabupatenItem();
                                    kabupatenItem.setId(jsonKab.getInt("id"));
                                    kabupatenItem.setNama(jsonKab.getString("nama"));
                                    kabupaten.add(kabupatenItem);

                                }
                                JSONArray jsKec = jsonRESULTS.getJSONObject("data").getJSONArray("kecamatan");
                                int len_jsKec = jsKec.length();
                                for (int i=0; i<len_jsKec; i++){
                                    JSONObject jsonKec = jsKec.getJSONObject(i);
                                    KecamatanItem kecamatanItem = new KecamatanItem();
                                    kecamatanItem.setId(jsonKec.getInt("id"));
                                    kecamatanItem.setNama(jsonKec.getString("nama"));
                                    kecamatan.add(kecamatanItem);

                                }
                                JSONArray jsKel = jsonRESULTS.getJSONObject("data").getJSONArray("kelurahan");
                                int len_jsKel = jsKel.length();
                                for (int i=0; i<len_jsKel; i++){
                                    JSONObject jsonKel = jsKel.getJSONObject(i);
                                    KelurahanItem kelurahanItem = new KelurahanItem();
                                    kelurahanItem.setId(jsonKel.getInt("id"));
                                    kelurahanItem.setNama(jsonKel.getString("nama"));
                                    kelurahan.add(kelurahanItem);

                                }
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
                                    modelClass.setHourSecond(json.getString("hour_second"));
                                    modelClass.setTypeClass(json.getString("type_class"));
                                  //  modelClass.setCapacity(json.getInt("capacity"));
                                    modelClass.setNameSpots(json.getString("name_spots"));
                                    modelClass.setAddress(json.getString("address"));
                                    modelClass.setLat(json.getDouble("lat"));
                                    modelClass.setLng(json.getDouble("lng"));
                                    classroom.add(modelClass);
                                    Log.d("p",json.getString("id").toString());
                                }


                                Employee model = new Employee();
                                model.setId(id);
                                model.setName(name);
                                model.setAddress(address);
                                model.setBirthday(birthday);
                                model.setPhone(phone);
                                model.setGender(gender);
                                model.setUserId(user_id);
                                model.setPropinsiId(prop_id);
                                model.setKabupatenId(kab_id);
                                model.setKecamatanId(kec_id);
                                model.setKelurahanId(kel_id);
                                model.setEmail(email);
                                model.setUsername(user);
                                model.setAvatar(avatar);
                                model.setPropinsi(propinsi);
                                model.setKabupaten(kabupaten);
                                model.setKecamatan(kecamatan);
                                model.setKelurahan(kelurahan);
                                model.setClassroom(classroom);
                                emp.add(model);
                                Log.d("Berhasil :",name);
                                Log.d("id", emp.toString());

                                session.createLoginSession(String.valueOf(id), name, user, email);
                                sessionAttendances.createSessionAttendances("0","0" , "0","0");
                                view.hideProgressbar();

                                Intent intent = new Intent(con, ReminderActivity.class);
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
