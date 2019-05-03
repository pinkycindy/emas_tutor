package com.pinkycindy.emas_tutor.modul.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;

import com.pinkycindy.emas_tutor.R;

/**
 * Created by Pinky Cindy
 */
public class AlarmReceiver extends BroadcastReceiver {
    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent){
        //Create New Intent


        View v = new View(context);
        mp= MediaPlayer.create(context, R.raw.alarm3);
        mp.start();

        Intent i = new Intent(context, WindowActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }



}