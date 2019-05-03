package com.pinkycindy.emas_tutor.modul.alarm;

import com.pinkycindy.emas_tutor.data.model.ClassroomItem;

import java.util.ArrayList;

/**
 * Created by Pinky Cindy
 */
public interface AlarmContract {

    interface view{
        void showWindow();
        void createAlarm(ArrayList<ClassroomItem> classsroom);

    }

    interface presenter{
        void createalarm(ArrayList<ClassroomItem> classsroom);

    }
}
