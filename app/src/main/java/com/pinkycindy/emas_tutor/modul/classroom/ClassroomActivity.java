package com.pinkycindy.emas_tutor.modul.classroom;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.pinkycindy.emas_tutor.Base.BaseActivity;
import com.pinkycindy.emas_tutor.Base.RecyclerTouchListener;
import com.pinkycindy.emas_tutor.R;
import com.pinkycindy.emas_tutor.data.model.ClassroomItem;
import com.pinkycindy.emas_tutor.data.source.local.SessionManager;
import com.pinkycindy.emas_tutor.modul.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.ButterKnife;

/**
 * Created by Pinky Cindy
 */
public class ClassroomActivity extends BaseActivity implements ClassroomContract.view {

    private ArrayList<ClassroomItem> classrooms;
    private ClassroomAdapter classroomAdapter;
    private ClassroomContract.presenter presenter;
    private ProgressDialog progressDialog;
    RecyclerView recyclerView;
    SessionManager sessionManager;
    String empId;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom);

        unbinder = ButterKnife.bind(this);
        presenter = new ClassroomPresenter(this);
        progressDialog = new ProgressDialog(ClassroomActivity.this);


        sessionManager = new SessionManager(getApplicationContext());
        HashMap<String, String> user = sessionManager.getUserDetails();
        empId = user.get(SessionManager.KEY_ID);

        Log.d("id", empId);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        presenter.loadClassroom();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showProgress() {

        progressDialog.setMessage("Please wait .....");
        progressDialog.show();

    }

    @Override
    public void showPesan() {
        Toast.makeText(getApplicationContext(), "Kelas dipilih!", Toast.LENGTH_LONG).show();

    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();

    }

    @Override
    public void showDataClass(ArrayList<ClassroomItem> classrooms) {

        classroomAdapter = new ClassroomAdapter(classrooms, getApplicationContext());
        recyclerView.setAdapter(classroomAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView,
                        new RecyclerTouchListener.ClickListener() {
                            @Override
                            public void onClick(View view, int position) {
                                ClassroomItem classroom = classroomAdapter.getItem(position);
                                presenter.pilihClass(classroom, empId);
                                //  Toast.makeText(getActivity(), "Absen sukses!", Toast.LENGTH_LONG).show();
//                        CurrentLocation location = new CurrentLocation(ClassroomActivity.this);
//
//                        if (location.getIsGPSTrackingEnabled()) {
//                            Log.d("data current lat : ", String.valueOf(location.getLatitude()));
//                            Log.d("data current lng : ", String.valueOf(location.getLongitude()));
//                        }
//                        else{
//                            location.showSettingsAlert();
//                            Log.d("gagal", "gagal");
//                        }
//                        Classroom classrooms = classroomAdapter.getItem(position);
//                        presenter.addAbsen(classrooms);
                            }

                            @Override
                            public void onLongClick(View view, int position) {

                            }
                        })
        );

    }

    @Override
    public void openclassroom() {

        progressDialog.dismiss();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void absen() {

    }
}
