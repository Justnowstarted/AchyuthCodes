package com.example.sakumar.thirdi;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RatingActivity extends AppCompatActivity {
    Button submit;
    RatingBar rate1;
    EditText ed,ed1,ed2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        submit = (Button) findViewById(R.id.button3);
        rate1 = (RatingBar) findViewById(R.id.ratingBar);
       // ed =(EditText) findViewById(R.id.editText2);
      //  ed1 =(EditText) findViewById(R.id.editText);
       // ed2 =(EditText) findViewById(R.id.editText3);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        List<String> categories = new ArrayList<String>();
        categories.add("Adgaon");
        categories.add("Ambad");
        categories.add("Bhadrakali");
        categories.add("Deolali");
        categories.add("Gangapur");
        categories.add("Indira Nagar");
        categories.add("Mhasrul");
        categories.add("Mumbai Naka");
        categories.add("Nashik Road");
        categories.add("Panchavati");
        categories.add("Sarkarwada");
        categories.add("Satpur");
        categories.add("Upnagar");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RatingActivity.this,String.valueOf(rate1.getRating()),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RatingActivity.this,MainActivity.class);
                startActivity(intent);

               // Toast.makeText(RatingActivity.this,
               // String name = ed.getText().toString();
                //String location = ed1.getText().toString();
                //String rating = String.valueOf(rate1.getRating());
                //String comments = ed2.getText().toString();

                //Rateing rateing;

               // rateing = new Rateing(name,location, rating,comments);

              /* ServerReq serverReq = new ServerReq(getApplicationContext());
                serverReq.StoreDataInBackground(rateing);
                Intent intent =new Intent(RatingActivity.this,MainActivity.class);
                startActivity(intent);
                */




            }
        });

        /*rate1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        }); */
    }

}

