package com.pinkycindy.emas_tutor.modul.profil;

import com.pinkycindy.emas_tutor.data.model.Employee;

import java.util.ArrayList;

/**
 * Created by Pinky Cindy
 */
public interface ProfilContract {
    interface view{
        void showProfil(ArrayList<Employee> employees);
    }

    interface presenter{
        void getProfil(String emp_id);
    }

}
