package com.example.sakumar.thirdi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.location.LocationListener;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
//import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
//import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
//import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


public class MainActivity extends AppCompatActivity implements ConnectionCallbacks, OnConnectionFailedListener {
    private Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;
    double longitude, latitude;
    private static final String TAG = MainActivity.class.getSimpleName();
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;

    Button call, SOS, rate,cit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call = (Button) findViewById(R.id.button);
        SOS = (Button) findViewById(R.id.button2);
        rate = (Button) findViewById(R.id.button4);
        cit =(Button) findViewById(R.id.button6);
        if (checkPlayServices()) {
            // Building the GoogleApi client
            buildGoogleApiClient();
        }


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callI = new Intent(Intent.ACTION_CALL);
                callI.setData(Uri.parse("tel:" + 100));
                try {
                    startActivity(callI);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                Intent nxtactivity = new Intent("com.example.sakumar.thirdi.RatingActivity");
                startActivity(nxtactivity);
            }
        });
        cit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inti =new Intent(getApplicationContext(),see.class);
                startActivity(inti);
            }
        });
    }

    public void displayLocation() {


        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

       /* Toast t2 = Toast.makeText(getApplicationContext(), "displaylocationCalled", Toast.LENGTH_SHORT);
        t2.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        t2.show();*/
        //mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (mLastLocation != null) {
            latitude = mLastLocation.getLatitude();
            longitude = mLastLocation.getLongitude();
        } else {
            showGPSDisabledAlertToUser();
        }
    }

    protected synchronized void buildGoogleApiClient() {
        // if(mGoogleApiClient == null) {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }
       /* Toast t8 = Toast.makeText(getApplicationContext(), "buildGoogleApiClient Called", Toast.LENGTH_SHORT);
        t8.show();*/


    /***************************************************/

    private boolean checkPlayServices() {
        // Toast t7 = Toast.makeText(getApplicationContext(), "CheckPlayServicesCalled", Toast.LENGTH_SHORT);
        //t7.show();

        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
                finish();
            }
            return false;
        }

        return true;
    }

    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
        //  Toast t6 = Toast.makeText(getApplicationContext(), "onStartCalled", Toast.LENGTH_SHORT);
        //t6.show();
    }

    @Override
    protected void onResume() {
        // Toast t5 = Toast.makeText(getApplicationContext(), "ResumedCalled", Toast.LENGTH_SHORT);
        //t5.show();
        super.onResume();

        checkPlayServices();


    }

    /**
     * Google api callback methods
     */
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = "
                + result.getErrorCode());
    }

    public void onConnected(Bundle arg0) {
        // Toast t1 = Toast.makeText(getApplicationContext(), "OnConnectedCalled", Toast.LENGTH_SHORT);
        //t1.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 6, 0);
        //t1.show();
        // Once connected with google api, get the location

        displayLocation();
    }

    public void onConnectionSuspended(int arg0) {
        mGoogleApiClient.connect();
        // Toast t3 = Toast.makeText(getApplicationContext(), "connection suspended", Toast.LENGTH_SHORT);
        //t3.show();
    }

    private void showGPSDisabledAlertToUser() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("GPS is disabled in your device. Would you like to enable it?")
                .setCancelable(false)
                .setPositiveButton("Enable GPS", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent callGPSSettingIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(callGPSSettingIntent);

                        //checkPlayServices();
                    }

                });

        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

    }// ;


    public void send(View view) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if(mLastLocation != null) {
            latitude = mLastLocation.getLatitude();
            longitude = mLastLocation.getLongitude();
        }


        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        //String uri = "http://maps.google.com/maps?saddr=" + mLastLocation.getLatitude()+","+currentLocation.getLongitude();

        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address" ,"9799235966;7382781729;7587298523");
        smsIntent.putExtra("sms_body", "I am in danger,  http://maps.google.com/maps?saddr=" + latitude +","+ longitude);

       // smsIntent.putExtra("wysokosc",displayLocation().latitude);
        //i.putExtra("speed", PSpeed);

        startActivity(smsIntent);


    }

}
