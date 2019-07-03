package com.pinkycindy.emas_tutor.modul.main;

import com.pinkycindy.emas_tutor.data.model.ClassroomItem;

import java.util.ArrayList;

/**
 * Created by Pinky Cindy
 */
public interface HomeContract  {
    interface view{
        void showSchedule(ArrayList<ClassroomItem> classrooms, Boolean sukses);

    }

    interface presenter{
        void getSchedule(String id, int day);

    }
}
