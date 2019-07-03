package com.pinkycindy.emas_tutor.modul.history;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pinkycindy.emas_tutor.Base.BaseFragment;
import com.pinkycindy.emas_tutor.R;
import com.pinkycindy.emas_tutor.data.model.Attendance;
import com.pinkycindy.emas_tutor.data.source.local.SessionManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by Pinky Cindy
 */
public class HistoryFragment extends BaseFragment implements HistoryContract.view {

    private HistoryContract.presenter presenter;
    private ImageButton ibDate;
    private TextView tvTgl, tvStatus, tvCheckin;
    private Button btnSearch;
    private int mYear, mMonth, mDay;
    private String empId, tgl;
    SessionManager sessionManager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new HistoryPresenter(this);

        sessionManager = new SessionManager(getActivity());
        HashMap<String, String> user = sessionManager.getUserDetails();
        empId = user.get(SessionManager.KEY_ID);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);


        ibDate =  view.findViewById(R.id.ib_date);
        tvTgl = view.findViewById(R.id.tv_tgl);
        tvStatus = view.findViewById(R.id.tv_status);
        tvCheckin = view.findViewById(R.id.tv_checkin);

        btnSearch = view.findViewById(R.id.btn_search);

        Calendar calNow = Calendar.getInstance();
        final Calendar calSet = (Calendar) calNow.clone();

        ibDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvTgl.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        calSet.set(Calendar.YEAR, year);
                        calSet.set(Calendar.MONTH, monthOfYear);
                        calSet.set(Calendar.DATE, dayOfMonth);
                        tgl = year+"-"+(monthOfYear+1)+"-"+dayOfMonth;
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getAttendances(empId, tgl);
            }
        });


        return view;


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getAttendances(empId, "2000-01-01");
    }


    @Override
    public void showAttendances(ArrayList<Attendance> attendances) {

        if(attendances.isEmpty()){

            tvStatus.setText("-");
            tvCheckin.setText("-");
        }
        else{
            tvStatus.setText("PRESENT");
            tvCheckin.setText(attendances.get(0).getCheckin());

        }


    }
}
