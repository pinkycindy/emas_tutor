package com.pinkycindy.emas_tutor.modul.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Pinky Cindy
 */
public class AlarmReceiver extends BroadcastReceiver {
    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        View v = new View(context);
     //   mp= MediaPlayer.create(context, R.raw.alarm);
        mp.start();

        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();
//        Intent i = new Intent(context, WindowActivity.class);
//        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        context.startActivity(i);
//        Intent i = new Intent(context, WindowActivity.class);
//        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        context.startActivity(i);


       // LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

        // Inflate the custom layout/view
//        View customView = inflater.inflate(R.layout.custom_layout,null);
//
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
//
//        PopupWindow pw = new PopupWindow(inflater.inflate(R.layout.popup_window, null, false),100,100, true);
//
//        pw.showAtLocation(v, Gravity.CENTER, 0, 0);
    }



}