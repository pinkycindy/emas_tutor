package com.pinkycindy.emas_tutor.modul.attendances;

import android.content.Context;

import com.pinkycindy.emas_tutor.data.source.local.SessionManager;

/**
 * Created by Pinky Cindy
 */
public class AttendancesPresenter implements AttendancesContract.presenter {


    private AttendancesContract.view view;
    SessionManager session ;
    Context con;

    public AttendancesPresenter(AttendancesContract.view view, Context con) {
        this.con=con;
        this.view=view;
    }

    @Override
    public void addAttendances(String emp_id, String id, int spot_id, Double lat, Double lng) {

    }
}
