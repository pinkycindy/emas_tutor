package com.pinkycindy.emas_tutor.modul.reminder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.pinkycindy.emas_tutor.data.model.ClassroomItem;
import com.pinkycindy.emas_tutor.data.source.local.SessionManager;

import java.util.ArrayList;
import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by Pinky Cindy
 */
public class ReminderPresenter implements ReminderContract.presenter{

    private ReminderContract.view view;
    SessionManager session ;
    Context con;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;


    public ReminderPresenter(ReminderContract.view view, Context con) {
        this.view = view;
        this.con = con;
    }


    @Override
    public void createalarm(ArrayList<ClassroomItem> classsroom) {

        int lenght = classsroom.size();


        AlarmManager[] alarmManagers = new AlarmManager[lenght];
        Intent intents[] = new Intent[alarmManagers.length];
        for(int i=0;i<alarmManagers.length;i++){
            int day1 = classsroom.get(i).getDayFirst();
            String hour1 = classsroom.get(i).getHourFirst();
            String[] kata = hour1.split(":");
            String jam1 = kata[0];
            String menit1 = kata[1];
            int spotid = classsroom.get(i).getSpotId();
            intents[i] = new Intent(con, ReminderReceiver.class);
            intents[i].putExtra("id",classsroom.get(i).getId());
            intents[i].putExtra("spot_id", classsroom.get(i).getSpotId());
            Log.d("spot", String.valueOf(spotid));
            intents[i].putExtra("lat", classsroom.get(i).getLat());
            intents[i].putExtra("lng", classsroom.get(i).getLng());
//            intents[i].putExtra("Alarm_no", i);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(con,i,intents[i],0);
            Calendar cal=Calendar.getInstance();
            cal.set(Calendar.DAY_OF_WEEK, day1);
            cal.set(Calendar.HOUR_OF_DAY, 6);
            cal.set(Calendar.MINUTE, 54);
            cal.set(Calendar.SECOND, 0);
            //reminder 10 menit sebelum jadwal

          //  Log.d("cal lama", cal.getTime().toString());
            if(cal.getTimeInMillis() < System.currentTimeMillis()) {
                cal.add(Calendar.DAY_OF_YEAR, 7);
            }
            Log.d("cal baru", cal.getTime().toString());

            alarmManagers[i] = (AlarmManager)con.getSystemService(ALARM_SERVICE);
            alarmManagers[i].set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),pendingIntent);

        }
        view.showWindow();
//        for(int i=alarmManagers.length;i<(alarmManagers.length*2);i++){
//            int day2 = classsroom.get(i).getDaySecond();
//            String hour2 = classsroom.get(i).getHourSecond();
//            String[] kata2 = hour2.split(":");
//            String jam2 = kata2[0];
//            String menit2 = kata2[1];
//
//            intents[i] = new Intent(con,ReminderReceiver.class);
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(con,i,intents[i],PendingIntent.FLAG_UPDATE_CURRENT|  Intent.FILL_IN_DATA);
//            Calendar cal=Calendar.getInstance();
//            cal.set(Calendar.DAY_OF_WEEK, day2);
//            cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(jam2));
//            cal.set(Calendar.MINUTE, Integer.parseInt(menit2));
//            cal.set(Calendar.SECOND,0);
//
//            alarmManagers[i] = (AlarmManager)con.getSystemService(ALARM_SERVICE);
//            alarmManagers[i].set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pendingIntent);
//
//        }



//        Intent intent = new Intent(con, ReminderReceiver.class);
//        pendingIntent = PendingIntent.getBroadcast(
//                con, 234324243, intent, 0);
//        alarmManager = (AlarmManager) con.getSystemService(ALARM_SERVICE);
//
//        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
//                + (15 * 1000), pendingIntent);
//        Toast.makeText(con, "Alarm set in " + 15 + " seconds",Toast.LENGTH_LONG).show();
    }
}
