package com.mateoj.multiactivitydrawer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.mateoj.multiactivitydrawer.Interfaces.GoogleClient;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Alert_Pref extends BaseActivity {

    Switch A,T,S,E;
    Boolean s1,s2,s3,s4;
    Button b1;
    Call<ResponseBody> call;


    public static final String PREFS_NAME = "LoginPrefs";

    public static final String MULTIPART_FORM_DATA = "multipart/form-data";

    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert__pref);

        settings = getSharedPreferences(PREFS_NAME, 0);

        A=(Switch) findViewById(R.id.togglebutton);
        T=(Switch) findViewById(R.id.switch1);
        S=(Switch) findViewById(R.id.switch2);
        E=(Switch) findViewById(R.id.switch3);


        b1= (Button)findViewById(R.id.save);


        A.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                s1=isChecked;
            }
        });


        T.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                s2=isChecked;
            }
        });


        S.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {

                s3=isChecked;
            }
        });


        E.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                s4=isChecked;

            }
        });

        assert b1 != null;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              submitPreferences(s1,s2,s3,s4);


            }

        });


    }


    @Override
    protected boolean useDrawerToggle() {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // if (item.getItemId() == R.id.action_noHamburger)
        //   return true;

            if (item.getItemId() == android.R.id.home)
                // onBackPressed();
                startActivity(new Intent(this, MainActivity.class));

            return super.onOptionsItemSelected(item);


    }


    public String getUserDetails(){

        // SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        String hello= settings.getString("User", "");

        return hello;
    }





    private void submitPreferences(Boolean a, Boolean b, Boolean c, Boolean d) {
        // create upload service client
        GoogleClient service =
                ServiceGenerator.createService(GoogleClient.class);



        RequestBody User = createPartFromString(String.valueOf(getUserDetails()));

        RequestBody emer = createPartFromString(String.valueOf(a));

        RequestBody traf = createPartFromString(String.valueOf(b));



        RequestBody saf = createPartFromString(String.valueOf(c));

        RequestBody area = createPartFromString(String.valueOf(d));





        call = service.AlertPref("http://52.11.160.94/reports/inc/forms/women_report.php",User,emer,saf,traf, area);
        call.enqueue(new Callback<ResponseBody>() {//http://3di.pe.hu/inc/forms/live_updates_form.php
            @Override
            public void onResponse(Call<ResponseBody> call,
                                   Response<ResponseBody> response) {
                Log.v("Upload", "success");

               // enableUI();


                Toast.makeText(getApplicationContext(),"Your preferences has been saved", Toast.LENGTH_SHORT).show();

               // getComplaintId();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                try {
                    Log.e("Upload error:", t.getMessage());
                  //  enableUI();


                    Toast.makeText(getApplicationContext(), "Sorry! Check your internet connection and try again", Toast.LENGTH_LONG).show();

                }catch (Exception e){
                    e.printStackTrace();

                    Toast.makeText(getApplicationContext(), "Sorry! Check your internet connection and try again", Toast.LENGTH_LONG).show();


                }
            }
        });
    }

    @NonNull
    private RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                MediaType.parse(MULTIPART_FORM_DATA), descriptionString);
    }

}



