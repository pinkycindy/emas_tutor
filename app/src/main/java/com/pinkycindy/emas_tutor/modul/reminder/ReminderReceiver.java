package com.pinkycindy.emas_tutor.modul.reminder;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.pinkycindy.emas_tutor.R;
import com.pinkycindy.emas_tutor.modul.service.AttendancesService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pinky Cindy
 */
public class ReminderReceiver extends BroadcastReceiver {

    MediaPlayer mp;

     int id, spot_id;
    Double lat, lng;
    ScheduledExecutorService exec ;
    @Override
    public void onReceive(final Context context, Intent intent){
        //Create New Intent


//get data class
        id = intent.getIntExtra("id", 0);
        spot_id = intent.getIntExtra("spot_id",0);
        lat = intent.getDoubleExtra("lat",0);
        lng = intent.getDoubleExtra("lng",0);

        //notification
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "English Massive";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            @SuppressLint("WrongConstant") NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_MAX);
            // Configure the notification channel.
            notificationChannel.setDescription("Sample Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID);
        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_classroom)
                .setTicker("Tutorialspoint")
                //.setPriority(Notification.PRIORITY_MAX)
                .setContentTitle("Teaching schedule in 10 minutes!")
                .setContentText("prepare yourself")
                .setContentInfo("Information")
                .setPriority(NotificationManager.IMPORTANCE_HIGH);
        notificationManager.notify(1, notificationBuilder.build());


        //View v = new View(context);
//        mp= MediaPlayer.create(context, R.raw.alarm3);
//        mp.start();



        Log.d("ID class", String.valueOf(id));
        Log.d("lat", String.valueOf(lat));
        Log.d("spot", String.valueOf(spot_id));

        //stop when 20 minutes
        //jalankan absensi service saat tiba waktu mengajar
        exec = Executors.newScheduledThreadPool(1);
        exec.schedule(new Runnable(){
            @Override
            public void run(){
                //run service to process attendances
                Intent i= new Intent(context, AttendancesService.class);
                i.putExtra("id",id);
                i.putExtra("spot_id", spot_id);
                i.putExtra("lat", lat);
                i.putExtra("lng", lng);
                context.startService(i);
            }
        }, 2, TimeUnit.MINUTES);


    }



}