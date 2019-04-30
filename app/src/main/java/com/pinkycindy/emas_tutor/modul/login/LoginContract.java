package com.pinkycindy.emas_tutor.modul.login;

/**
 * Created by Pinky Cindy
 */
public interface LoginContract {
    interface view{
        void showProgressbar();
        void hideProgressbar();
        void respond(String id, String nama, String email);
    }

    interface presenter{
        void requestLogin(String email, String pass);
        void createSession();
        void createReminder();
    }
}
