package com.pinkycindy.emas_tutor.modul.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.pinkycindy.emas_tutor.Base.BaseActivity;
import com.pinkycindy.emas_tutor.R;
import com.pinkycindy.emas_tutor.modul.MainActivity;
import com.pinkycindy.emas_tutor.modul.login.LoginActivity;

/**
 * Created by Pinky Cindy
 */
public class SplashscreenActivity extends BaseActivity implements SplashscreenContract.view{

    private SplashscreenContract.presenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        presenter = new SplashscreenPresenter(this, getApplicationContext());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.cekSession();
            }
        },2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void movectivity(int session) {
        if(session==1){
            startActivity(new Intent(SplashscreenActivity.this, MainActivity.class));
            finish();
        }else{
            startActivity(new Intent(SplashscreenActivity.this, LoginActivity.class));
            finish();

        }

    }
}
