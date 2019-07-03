package com.pinkycindy.emas_tutor.modul.attendances;

/**
 * Created by Pinky Cindy
 */
public interface AttendancesContract {

    interface view{
        void showProgressbar();
        void hideProgressbar();
        void respond(String id, String nama, String email);
    }

    interface presenter{
        void addAttendances(String emp_id, String id, int spot_id, Double lat, Double lng);

    }
}
