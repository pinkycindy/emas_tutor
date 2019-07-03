package com.pinkycindy.emas_tutor.modul.schedule.inDay;

import com.pinkycindy.emas_tutor.data.model.ClassroomItem;

import java.util.ArrayList;

/**
 * Created by Pinky Cindy
 */

public interface DayScheduleContract {

    interface view{
        void showSchedule(ArrayList<ClassroomItem> classrooms);

    }

    interface presenter{
        void getSchedule(String id, int day);

    }

}
