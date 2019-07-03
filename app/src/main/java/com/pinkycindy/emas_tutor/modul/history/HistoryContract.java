package com.pinkycindy.emas_tutor.modul.history;

import com.pinkycindy.emas_tutor.data.model.Attendance;

import java.util.ArrayList;

/**
 * Created by Pinky Cindy
 */
public interface HistoryContract  {
    interface view{
        void showAttendances(ArrayList<Attendance> attendances);

    }

    interface presenter{
        void getAttendances(String emp_id, String tgl);

    }
}
