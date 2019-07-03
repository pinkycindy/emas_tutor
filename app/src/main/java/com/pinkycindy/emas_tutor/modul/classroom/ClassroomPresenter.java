package com.pinkycindy.emas_tutor.modul.classroom;

import android.util.Log;

import com.pinkycindy.emas_tutor.data.model.ClassroomItem;
import com.pinkycindy.emas_tutor.data.model.SpotItem;
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
public class ClassroomPresenter implements ClassroomContract.presenter {

   private ClassroomContract.view view;
   ArrayList<ClassroomItem> classroom;

    public ClassroomPresenter(ClassroomContract.view view) {
        this.view = view;
    }

    @Override
    public void loadClassroom() {
        Log.d("run", "api");
        ApiInterface apiService = ApiConnection.getClient();
        apiService.getClassEmpty()
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            Log.d("responses", String.valueOf(response));
                            try {
                                classroom = new ArrayList<ClassroomItem>();
                                Log.d("classroom", String.valueOf(classroom));

                                JSONObject jsonObject = new JSONObject(response.body().string());

                                JSONArray jsonArray = jsonObject.getJSONArray("data");


                                SpotItem spotList = new SpotItem();

                                for (int i = 0; i < jsonArray.length(); i++)
                                {
                                    JSONObject json = jsonArray.getJSONObject(i);
                                    Log.d("name",json.getString("name"));
                                    ClassroomItem classroomList = new ClassroomItem();
                                    classroomList.setId(json.getInt("id"));
                                    classroomList.setName(json.getString("name"));
                                    classroomList.setSpotId(json.getInt("spot_id"));
                                    classroomList.setDescription(json.getString("description"));
                                    classroomList.setDayFirst(json.getInt("day_first"));
                                    classroomList.setHourFirst(json.getString("hour_first"));
                                    classroomList.setTypeClass(json.getString("type_class"));
                                    classroomList.setNameSpots(json.getString("spot_name"));
                                    classroomList.setAddress(json.getString("address"));
                                    classroomList.setLat(json.getDouble("lat"));
                                    classroomList.setLng(json.getDouble("lng"));

                                    classroom.add(classroomList);
//
//
                                }


                                Log.d("classroom", String.valueOf(classroom));

                                if (classroom.isEmpty()){
                                    view.hideProgress();
                                }
                                else {
                                    view.showDataClass(classroom);
                                    view.hideProgress();
                                }


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

    @Override
    public void pilihClass(ClassroomItem classroomItem, String id) {
        view.showPesan();
        ApiInterface apiService = ApiConnection.getClient();
        apiService.chooseClassroom(String.valueOf(classroomItem.getId()), id)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            Log.d("responses", String.valueOf(response));
                            try {

                                Log.d("classroom", String.valueOf(classroom));

                                JSONObject jsonObject = new JSONObject(response.body().string());

                                Integer c = jsonObject.getJSONObject("data").getInt("id");
                                Log.d("classroom", String.valueOf(c));
                                view.openclassroom();
//
//




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
