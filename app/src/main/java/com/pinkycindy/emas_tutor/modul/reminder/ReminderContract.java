package com.pinkycindy.emas_tutor.modul.reminder;

import com.pinkycindy.emas_tutor.data.model.ClassroomItem;

import java.util.ArrayList;

/**
 * Created by Pinky Cindy
 */
public interface ReminderContract {

    interface view{
        void showWindow();
        void createAlarm(ArrayList<ClassroomItem> classsroom);

    }

    interface presenter{
        void createalarm(ArrayList<ClassroomItem> classsroom);

    }
}
