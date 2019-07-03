package com.pinkycindy.emas_tutor.modul.login;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.test.mock.MockPackageManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pinkycindy.emas_tutor.Base.BaseActivity;
import com.pinkycindy.emas_tutor.R;
import com.pinkycindy.emas_tutor.modul.MainActivity;
import com.pinkycindy.emas_tutor.modul.service.GPSTracker;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Pinky Cindy
 */
public class LoginActivity extends BaseActivity implements LoginContract.view {

    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPass;



    private LoginContract.presenter presenter;
    private ProgressDialog progressDialog;

    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String TAG = LoginActivity.class.getSimpleName();

    // GPSTracker class
    GPSTracker gps;

//    SessionManager session;
//    SessionAttendances

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);
        presenter = new LoginPresenter(this, getApplicationContext());
        progressDialog = new ProgressDialog(LoginActivity.this);

        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission)
                    != MockPackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @OnClick(R.id.btn_login)
    public void onClick(View view){

//        if(areThereMockPermissionApps(getApplicationContext())){
//            Log.d("mock in act", String.valueOf(areThereMockPermissionApps(getApplicationContext())));
//        }else{
//            Log.d("mock in act", "false");
//
//        }
//        gps = new GPSTracker(LoginActivity.this);
//
//        // check if GPS enabled
//        if(gps.canGetLocation()){
//
//            double latitude = gps.getLatitude();
//            double longitude = gps.getLongitude();
//
//            // \n is for new line
//            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: "
//                    + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
//        }else{
//            // can't get location
//            // GPS or Network is not enabled
//            // Ask user to enable GPS/network in settings
//            gps.showSettingsAlert();
//        }

        String email= etEmail.getText().toString();
        String pass = etPass.getText().toString();
        presenter.requestLogin(email, pass);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showProgressbar() {
        progressDialog.setMessage("Please wait .....");
        progressDialog.show();

    }

    @Override
    public void hideProgressbar() {
        progressDialog.dismiss();

    }

    @Override
    public void respond(String id, String nama, String email) {
        Intent i= new Intent(LoginActivity.this, MainActivity.class);
        LoginActivity.this.startActivity(i);

    }

    public static boolean isAllowMockLocationsOn(Context context) {
        // returns true if mock location enabled, false if not enabled.
        if (android.os.Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) {
            if (Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ALLOW_MOCK_LOCATION).equals("0"))
                return false;
            else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static boolean checkForAllowMockLocationsApps(Context context) {

        int count = 0;

        PackageManager pm = context.getPackageManager();
        List<ApplicationInfo> packages =
                pm.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo applicationInfo : packages) {
            try {
                PackageInfo packageInfo = pm.getPackageInfo(applicationInfo.packageName,
                        PackageManager.GET_PERMISSIONS);

                // Get Permissions
                String[] requestedPermissions = packageInfo.requestedPermissions;

                if (requestedPermissions != null) {
                    for (int i = 0; i < requestedPermissions.length; i++) {
                        if (requestedPermissions[i]
                                .equals("android.permission.ACCESS_MOCK_LOCATION")
                                && !applicationInfo.packageName.equals(context.getPackageName())) {
                            count++;
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(TAG, "Got exception " + e.getMessage());
            }
        }

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

}
