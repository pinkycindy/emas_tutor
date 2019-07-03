package com.pinkycindy.emas_tutor.modul.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import com.pinkycindy.emas_tutor.data.source.local.SessionAttendances;
import com.pinkycindy.emas_tutor.data.source.remote.ApiConnection;
import com.pinkycindy.emas_tutor.data.source.remote.ApiInterface;
import com.pinkycindy.emas_tutor.modul.MainActivity;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Pinky Cindy
 */
public class CloseAttendancesReceiver  extends BroadcastReceiver {

    int attendances_id, employee_id, classroom_id, spots_id;
    Double lat_spot, lng_spot, latitude,longitude, distance;
    String checkin;
    ScheduledExecutorService exec ;
    SessionAttendances sessionAttendances;

    @Override
    public void onReceive(final Context context, Intent intent) {

        sessionAttendances = new SessionAttendances(context);

        attendances_id= intent.getIntExtra("id",0);
        spots_id = intent.getIntExtra("spot_id",0);
        classroom_id = intent.getIntExtra("class_id",0);
        checkin = intent.getStringExtra("checkin");
        lat_spot = intent.getDoubleExtra("lat",0);
        lng_spot = intent.getDoubleExtra("lng",0);

        //get location user
        GPSTracker locationService = new GPSTracker(context);
        latitude = locationService.getLatitude();
        longitude = locationService.getLongitude();

        distance = countDistance(latitude, longitude, lat_spot, lng_spot);
        Log.d("jarak : ", String.valueOf(distance));
        //getJarak(latitude, longitude,lat, lng);

        //stop when 20 minutes
        exec = Executors.newScheduledThreadPool(1);
        exec.schedule(new Runnable(){
            @Override
            public void run(){
                stop(context);
                updateAttendances(context, attendances_id, latitude, longitude);
                Intent i = new Intent(context, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //i.putExtra("up", up);
                context.startActivity(i);

            }
        }, 3, TimeUnit.MINUTES);

        //cek distances
        if(distance>10){ //jika keluar jarak logout otomatis
            Log.d("in radius", "flase");
            stop(context);
            updateAttendances(context, attendances_id, latitude, longitude);

        }
        else{
            Log.d("in radius", "true");
           // Toast.makeText(context, "Anda belum di lokasi !", Toast.LENGTH_SHORT).show();
        }

    }

    private void updateAttendances(final Context context, int attendances_id, Double latitude, Double longitude) {

        ApiInterface apiService = ApiConnection.getClient();
        apiService.updateAttendaces(attendances_id, latitude, longitude)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            Log.d("responses", String.valueOf(response));
                            sessionAttendances.createSessionAttendances("0","0","0","0");

                            Toast.makeText(context, "Attendances CLOSE !", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(context, MainActivity.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            //i.putExtra("up", up);
                            context.startActivity(i);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                    }


                });
    }

    private Double countDistance(Double latitude, Double longitude, Double lat, Double lng) {
        Location locationA = new Location("point A");
        //Convert from string to double and then process
        locationA.setLatitude(latitude);
        locationA.setLongitude(longitude);
        Location locationB = new Location("point B");

        locationB.setLatitude(lat);
        locationB.setLongitude(lng);

        //jarak dalam meter
        return Double.valueOf(locationA.distanceTo(locationB));

    }

    private void stop(Context context) {
        Log.d("stop","yes");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent myIntent = new Intent(context.getApplicationContext(), CloseAttendancesReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context.getApplicationContext(), 1111, myIntent, 0);
        alarmManager.cancel(pendingIntent);
        exec.shutdownNow();

    }
}
