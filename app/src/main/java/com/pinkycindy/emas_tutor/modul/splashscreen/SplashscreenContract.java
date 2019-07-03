package com.pinkycindy.emas_tutor.modul.splashscreen;

/**
 * Created by Pinky Cindy
 */
public interface SplashscreenContract {
    interface view{
        void movectivity(int session);
   }

    interface presenter {
        void cekSession();
    }
}
