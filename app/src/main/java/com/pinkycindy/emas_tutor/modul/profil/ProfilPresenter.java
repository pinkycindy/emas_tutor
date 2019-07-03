package com.pinkycindy.emas_tutor.modul.profil;

import android.util.Log;

import com.pinkycindy.emas_tutor.data.model.Employee;
import com.pinkycindy.emas_tutor.data.source.remote.ApiConnection;
import com.pinkycindy.emas_tutor.data.source.remote.ApiInterface;

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
public class ProfilPresenter implements ProfilContract.presenter {

    ProfilContract.view view;
    ArrayList<Employee> employees;


    public ProfilPresenter(ProfilContract.view view) {
        this.view = view;
    }

    @Override
    public void getProfil(String emp_id) {
        Log.d("empId", emp_id);
        ApiInterface apiService = ApiConnection.getClient();
        apiService.getProfil(emp_id)
                .enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            Log.d("responses", String.valueOf(response));
                            try {
                                employees = new ArrayList<Employee>();
                                Log.d("employee", String.valueOf(employees));

                                JSONObject jsonObject = new JSONObject(response.body().string());
                                JSONArray jsonArray = jsonObject.getJSONArray("data");
                                for (int i = 0; i < jsonArray.length(); i++)
                                {
                                    JSONObject json = jsonArray.getJSONObject(i);
                                    Employee employeelist = new Employee();
                                    employeelist.setId(json.getInt("id"));
                                    employeelist.setName(json.getString("name"));
                                    employeelist.setUsername(json.getString("username"));
                                    employeelist.setEmail(json.getString("email"));
                                    employeelist.setAddress(json.getString("address"));
                                    employeelist.setPhone(json.getString("phone"));
                                    employeelist.setGender(json.getString("gender"));
                                    employeelist.setBirthday(json.getString("birthday"));
                                    employeelist.setAvatar(json.getString("avatar_file_name"));
                                    employees.add(employeelist);
                                }


                                Log.d("attendances", String.valueOf(employees));

                                view.showProfil(employees);


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
                    }


                });


    }
}
