package com.pinkycindy.emas_tutor.modul.history;

import android.util.Log;

import com.pinkycindy.emas_tutor.data.model.Attendance;
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
public class HistoryPresenter implements HistoryContract.presenter{

    private HistoryContract.view view;
    ArrayList<Attendance> attendances;

    public HistoryPresenter(HistoryContract.view view) {
        this.view = view;
    }

    @Override
    public void getAttendances(String emp_id, String tgl) {
        Log.d("empId", emp_id);
        Log.d("tgl", tgl);

        ApiInterface apiService = ApiConnection.getClient();
        apiService.cekHistoryAttendances(emp_id, tgl)
                .enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            Log.d("responses", String.valueOf(response));
                            try {
                                attendances = new ArrayList<Attendance>();
                                Log.d("classroom", String.valueOf(attendances));

                                JSONObject jsonObject = new JSONObject(response.body().string());
                                JSONArray jsonArray = jsonObject.getJSONArray("data");
                                for (int i = 0; i < jsonArray.length(); i++)
                                {
                                    JSONObject json = jsonArray.getJSONObject(i);


                                    Attendance attendancelist = new Attendance();
                                    attendancelist.setId(json.getInt("id"));
                                    attendancelist.setSpotName(json.getString("spot_name"));
                                    attendancelist.setClassroomName(json.getString("class_name"));
                                    attendancelist.setCheckin(json.getString("checkin"));
                                    attendancelist.setCheckout(json.getString("checkout"));
                                    attendances.add(attendancelist);
                                }


                                Log.d("attendances", String.valueOf(attendances));

                                view.showAttendances(attendances);


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
