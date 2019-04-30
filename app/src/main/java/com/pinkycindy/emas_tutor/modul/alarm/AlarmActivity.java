package com.pinkycindy.emas_tutor.modul.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.pinkycindy.emas_tutor.Base.BaseActivity;
import com.pinkycindy.emas_tutor.data.model.Employee;

import java.util.ArrayList;

/**
 * Created by Pinky Cindy
 */
public class AlarmActivity extends BaseActivity {

    PendingIntent pendingIntent;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        ArrayList<Employee> data_emp = new ArrayList<Employee>();
        data_emp = (ArrayList<Employee>) getIntent().getSerializableExtra("emp");

        //cek data
        String name = data_emp.get(0).getName();
        Log.d("namaa", name);



        Intent i = new Intent(AlarmActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(
                AlarmActivity.this, 234324243, i, 0);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);


        //ganti sesaui jadwal
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (15 * 1000), pendingIntent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
