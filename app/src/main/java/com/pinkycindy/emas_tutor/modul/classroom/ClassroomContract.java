package com.pinkycindy.emas_tutor.modul.classroom;

import com.pinkycindy.emas_tutor.data.model.ClassroomItem;

import java.util.ArrayList;

/**
 * Created by Pinky Cindy
 */
public interface ClassroomContract {
    interface view{
        void showProgress();
        void showPesan();
        void hideProgress();
        void showDataClass(ArrayList<ClassroomItem> classrooms);
        void openclassroom();
        void absen();

    }

    interface presenter{
        void loadClassroom();
        void pilihClass(ClassroomItem classroom, String id);

    }
}
