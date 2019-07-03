package com.pinkycindy.emas_tutor.modul.report;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.pinkycindy.emas_tutor.Base.BaseActivity;
import com.pinkycindy.emas_tutor.R;
import com.pinkycindy.emas_tutor.data.source.local.SessionManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * Created by Pinky Cindy
 */
public class ReportActivity extends BaseActivity implements OnItemSelectedListener, ReportContract.view {

    LineChartView lineChartView;
    ReportContract.presenter presenter;
    SessionManager sessionManager;
    String empId;
    String[] axisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct", "Nov", "Dec"};
            int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};
            private Spinner spYear;

@Override
protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        presenter = new ReportPresenter(this);

        sessionManager = new SessionManager(getApplicationContext());
        sessionManager.checkLogin();
        HashMap<String, String> user = sessionManager.getUserDetails();
        empId = user.get(SessionManager.KEY_ID);
        spYear = findViewById(R.id.sp_year);

        spYear.setOnItemSelectedListener(this);
        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = (thisYear-5); i <= (thisYear+100); i++) {
                years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, years);
        spYear.setAdapter(adapter);




}



        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();
                presenter.getReport(empId, item);

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        }
        public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
        }

        @Override
        public void showReport(int [] nilai) {


                lineChartView = findViewById(R.id.chart);
                List yAxisValues = new ArrayList();
                List axisValues = new ArrayList();
                Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));

                for (int i = 0; i < axisData.length; i++) {
                        axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
                }

                for (int i = 0; i < nilai.length; i++) {
                        yAxisValues.add(new PointValue(i, nilai[i]));
                }

                List lines = new ArrayList();
                lines.add(line);

                LineChartData data = new LineChartData();
                data.setLines(lines);

                Axis axis = new Axis();
                axis.setValues(axisValues);
                axis.setTextSize(16);
                axis.setTextColor(Color.parseColor("#03A9F4"));
                data.setAxisXBottom(axis);

                Axis yAxis = new Axis();
                yAxis.setName("Sales in millions");
                yAxis.setTextColor(Color.parseColor("#03A9F4"));
                yAxis.setTextSize(16);
                data.setAxisYLeft(yAxis);

                lineChartView.setLineChartData(data);
                Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
                viewport.top = 50;
                lineChartView.setMaximumViewport(viewport);
                lineChartView.setCurrentViewport(viewport);

        }
}
