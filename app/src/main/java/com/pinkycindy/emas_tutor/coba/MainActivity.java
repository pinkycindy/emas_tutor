package com.pinkycindy.emas_tutor.coba;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.pinkycindy.emas_tutor.R;
import com.pinkycindy.emas_tutor.modul.login.LoginActivity;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleApiClient mGoogleApiClient;
    private Location mCurrentLocation;
    private String mLastUpdateTime;
    private TextView mLatitudeTextView;
    private TextView mLongitudeTextView;
    private TextView mLastUpdateTimeTextView;
    private TextView mIsMockTextView;
    private TextView mAreMockLocationAppsPresentTextView;
    private TextView mIsMockLocationsOnTextView;
    private LocationRequest mLocationRequest;

    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String TAG = LoginActivity.class.getSimpleName();
    private static final int MY_PERMISSION_REQUEST_READ_FINE_LOCATION= 100;
    private static final int MY_PERMISSIONS_REQUEST_FINE_LOCATION = 111;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLatitudeTextView = (TextView) findViewById(R.id.txt_location_latitude);
        mLongitudeTextView = (TextView) findViewById(R.id.txt_location_longitude);
        mLastUpdateTimeTextView = (TextView) findViewById(R.id.txt_location_last_update_time);
        mIsMockTextView = (TextView) findViewById(R.id.txt_is_mock_text);
        mAreMockLocationAppsPresentTextView = (TextView) findViewById(R.id.txt_are_mock_location_apps_present);
        mIsMockLocationsOnTextView = (TextView) findViewById(R.id.txt_is_allow_mock_locations_on);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this, // Activity
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_FINE_LOCATION);
        }



    // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_FINE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted

                } else {
                    // permission was denied
                }
                return;
            }
        }
    }


    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        stopLocationUpdates();
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    protected void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient, this);
    }


    @Override
    public void onConnected(Bundle connectionHint) {
        createLocationRequest();
        startLocationUpdates();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
//        mLocationRequest.setInterval(10000);
//        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setInterval(2000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    protected void startLocationUpdates() {
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        mCurrentLocation = location;
        mLastUpdateTime = DateFormat.getTimeInstance().format(new Date());
        updateUI();
    }

    private void updateUI() {
        mLatitudeTextView.setText(String.valueOf(mCurrentLocation.getLatitude()));
        mLongitudeTextView.setText(String.valueOf(mCurrentLocation.getLongitude()));
        mLastUpdateTimeTextView.setText(mLastUpdateTime);
//        boolean isMock = MockLocationDetector.isLocationFromMockProvider(this, mCurrentLocation);
//        mIsMockTextView.setText(String.valueOf(isMock));
//        if (isMock) {
//            mIsMockTextView.setTextColor(ContextCompat.getColor(this, R.color.blue));
//        } else {
//            mIsMockTextView.setTextColor(ContextCompat.getColor(this, R.color.yellow));
//        }
        boolean mockLocationAppsPresent = MockLocationDetector.checkForAllowMockLocationsApps(this);
        mAreMockLocationAppsPresentTextView.setText(String.valueOf(mockLocationAppsPresent));
        if (mockLocationAppsPresent) {
            mAreMockLocationAppsPresentTextView.setTextColor(ContextCompat.getColor(this, R.color.blue));
        } else {
            mAreMockLocationAppsPresentTextView.setTextColor(ContextCompat.getColor(this, R.color.yellow));
        }
        boolean isAllowMockLocationsON = MockLocationDetector.isAllowMockLocationsOn(this);
        mIsMockLocationsOnTextView.setText(String.valueOf(isAllowMockLocationsON));
        if (isAllowMockLocationsON) {
            mIsMockLocationsOnTextView.setTextColor(ContextCompat.getColor(this, R.color.blue));
        } else {
            mIsMockLocationsOnTextView.setTextColor(ContextCompat.getColor(this, R.color.yellow));
        }
    }
}
