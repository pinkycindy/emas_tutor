package com.pinkycindy.emas_tutor.modul.attendances;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.pinkycindy.emas_tutor.Base.BaseActivity;

/**
 * Created by Pinky Cindy
 */
public class AttendancesActivity extends BaseActivity implements AttendancesContract.view{


    String emp_id, class_id;
    int spot_id;
    Double lat, lng;

    private AttendancesPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AttendancesPresenter(this, getApplicationContext());
        Intent intent = getIntent();
        emp_id = intent.getStringExtra("emp_id");
        class_id = intent.getStringExtra("class_id");
        spot_id = intent.getIntExtra("spot_id", 0);
        lat = intent.getDoubleExtra("lat", 0);
        lng = intent.getDoubleExtra("lng",0);

        Log.d("emp_di", emp_id);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void respond(String id, String nama, String email) {

    }


}
