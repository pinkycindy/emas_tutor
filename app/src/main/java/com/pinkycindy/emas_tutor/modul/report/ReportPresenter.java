package com.pinkycindy.emas_tutor.modul.report;

import android.util.Log;

import com.pinkycindy.emas_tutor.data.source.remote.ApiConnection;
import com.pinkycindy.emas_tutor.data.source.remote.ApiInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Pinky Cindy
 */
public class ReportPresenter implements ReportContract.presenter{

    ReportContract.view view;
    int[] nilai = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public ReportPresenter(ReportContract.view view) {
        this.view = view;
    }

    @Override
    public void getReport(String emp_id, String tahun) {

        Log.d("empId", emp_id);
        ApiInterface apiService = ApiConnection.getClient();
        apiService.getReport(emp_id, tahun)
                .enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            Log.d("responses", String.valueOf(response));
                            try {

                                JSONObject jsonObject = new JSONObject(response.body().string());
                                JSONArray jsonArray = jsonObject.getJSONArray("data");
                                for (int i = 0; i < jsonArray.length(); i++)
                                {
                                    JSONObject json = jsonArray.getJSONObject(i);
                                    String month = json.getString("month");
                                    nilai[Integer.parseInt(month)] = json.getInt("monthly_sum");
                                    Log.d("moth",month);
                                }

                                Log.d("nilai 5", String.valueOf(nilai[5]));
                                view.showReport(nilai);


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
