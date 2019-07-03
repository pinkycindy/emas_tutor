package com.pinkycindy.emas_tutor.modul.report;

/**
 * Created by Pinky Cindy
 */
public interface ReportContract {

    interface view{
        void showReport(int[] nilai);
    }

    interface presenter{
        void getReport(String emp_id, String tahun);
    }
}
