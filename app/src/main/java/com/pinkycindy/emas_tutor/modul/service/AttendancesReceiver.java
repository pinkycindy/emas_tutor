package com.pinkycindy.emas_tutor.modul.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

import com.pinkycindy.emas_tutor.data.model.Attendance;
import com.pinkycindy.emas_tutor.data.model.SpotItem;
import com.pinkycindy.emas_tutor.data.source.local.SessionAttendances;
import com.pinkycindy.emas_tutor.data.source.local.SessionManager;
import com.pinkycindy.emas_tutor.data.source.remote.ApiConnection;
import com.pinkycindy.emas_tutor.data.source.remote.ApiInterface;
import com.pinkycindy.emas_tutor.modul.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
public class AttendancesReceiver extends BroadcastReceiver {
    MediaPlayer mp;

    private static final int REQUEST_PERMISSIONS = 100;
    boolean boolean_permission;
    SharedPreferences mPref;
    SharedPreferences.Editor medit;
    Double latitude,longitude, lat, lng, distance;
    String emp_id, checkin;
    int spot_id, up, id;
    ScheduledExecutorService exec ;
    SessionManager session;
    ArrayList<Attendance> attendances ;
    ArrayList<SpotItem> spot;

    SessionAttendances sessionAttendances;

    int attendances_id, employee_id, classroom_id, spots_id;
    Double lat_spot, lng_spot;
    String address, name_spot;



    @Override
    public void onReceive(final Context context, Intent intent){

        session = new SessionManager(context);
        sessionAttendances = new SessionAttendances(context);
        session.checkLogin();
        HashMap<String, String> user = session.getUserDetails();
        emp_id = user.get(SessionManager.KEY_ID);
        //Create New Intent
        //Log.d("cek every 5 menit", "cek");

        //get location user
        GPSTracker locationService = new GPSTracker(context);
        latitude = locationService.getLatitude();
        longitude = locationService.getLongitude();
//        Log.d("latitude", String.valueOf(latitude));
//        Log.d("longitude", String.valueOf(longitude));

        //get location class
        id = intent.getIntExtra("id", id);
        spot_id = intent.getIntExtra("spot_id", 0);
        lat = intent.getDoubleExtra("lat",0);
        lng = intent.getDoubleExtra("lng",0);
//        Log.d("ID class 2 ", id);
//        Log.d("lat 2", String.valueOf(lat));
        Log.d("spot", String.valueOf(spot_id));



        //count distance
        distance = countDistance(latitude, longitude, lat, lng);
        Log.d("lat", String.valueOf(lat));
        Log.d("lng", String.valueOf(lng));
        Log.d("lat system ", String.valueOf(latitude));
        Log.d("lng system", String.valueOf(longitude));
        Log.d("jarak : ", String.valueOf(distance));
        getJarak(latitude, longitude,lat, lng);



        //stop when 20 minutes
        exec = Executors.newScheduledThreadPool(1);
        exec.schedule(new Runnable(){
            @Override
            public void run(){
                up=0;
                stop(context, up);
                Intent i = new Intent(context, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //i.putExtra("up", up);
                context.startActivity(i);

            }
        }, 3, TimeUnit.MINUTES);

        //cek distances
        if(distance<10){
            Log.d("in radius", "true");
            up=1;
            stop(context, up);
            addAttendances(context, emp_id, id, spot_id, lat, lng);

        }
        else{
            Log.d("in radius", "false");
            Toast.makeText(context, "Anda belum di lokasi !", Toast.LENGTH_SHORT).show();
        }

    }

    private void addAttendances(final Context con, String emp_id, int id, final int spot_id, Double lat, Double lng) {
        Log.d("add atttendaces :", "proses");
        Log.d("id", emp_id);
        Log.d("class", String.valueOf(id));
        Log.d("spot", String.valueOf(spot_id));

        ApiInterface apiService = ApiConnection.getClient();
        apiService.addAttendaces(emp_id,spot_id, id, lat, lng)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            Log.d("responses", String.valueOf(response));
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());

                                attendances = new ArrayList<Attendance>();
                                spot = new ArrayList<SpotItem>();
                                attendances_id = jsonRESULTS.getJSONObject("data").getInt("id");
                                employee_id = jsonRESULTS.getJSONObject("data").getInt("employee_id");
                                spots_id = jsonRESULTS.getJSONObject("data").getInt("spot_id");
                                classroom_id = jsonRESULTS.getJSONObject("data").getInt("classroom_id");
                                checkin = jsonRESULTS.getJSONObject("data").getString("checkin");
                                name_spot = jsonRESULTS.getJSONObject("data").getJSONArray("spots").getJSONObject(0).getString("name");
                                address =jsonRESULTS.getJSONObject("data").getJSONArray("spots").getJSONObject(0).getString("address");
                                lat_spot =jsonRESULTS.getJSONObject("data").getJSONArray("spots").getJSONObject(0).getDouble("lat");
                                lng_spot= jsonRESULTS.getJSONObject("data").getJSONArray("spots").getJSONObject(0).getDouble("lng");



                                Log.d("attendances", String.valueOf(attendances_id));
                                sessionAttendances.createSessionAttendances(String.valueOf(attendances_id),name_spot , address,checkin);


                                Intent in = new Intent(con, MainActivity.class);
                                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                //i.putExtra("up", up);
                                con.startActivity(in);

                                Intent i= new Intent(con, CloseAttendancesService.class);
                                i.putExtra("id",attendances_id);
                                i.putExtra("emp_id", employee_id);
                                i.putExtra("class_id", classroom_id);
                                i.putExtra("checkin", checkin);
                                i.putExtra("spot_id", spots_id);
                                i.putExtra("lat", lat_spot);
                                i.putExtra("lng", lng_spot);
                                con.startService(i);




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

    private void stop(Context context, int up) {
        Log.d("stop","yes");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent myIntent = new Intent(context.getApplicationContext(), AttendancesReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context.getApplicationContext(), 123, myIntent, 0);
        alarmManager.cancel(pendingIntent);
        exec.shutdownNow();

//        String as = Context.ALARM_SERVICE;
//        AlarmManager amg = (AlarmManager) context.getSystemService(as);
//        PendingIntent myIntent = PendingIntent.getBroadcast(context, 123, intent1, 0);
//        amg.cancel(myIntent);




    }

    public void getJarak(double lat1, double lon1, double lat2, double lon2) {

        final int R = 6371; // Radious of the earth

        Double latDistance = toRad(lat2-lat1);

        Double lonDistance = toRad(lon2-lon1);

        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +

                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *

                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        Double distance = R * c;

        distance=distance;

        Log.d("The distance :", String.valueOf(distance));



    }



    private static Double toRad(Double value) {

        return value * Math.PI / 180;

    }




}