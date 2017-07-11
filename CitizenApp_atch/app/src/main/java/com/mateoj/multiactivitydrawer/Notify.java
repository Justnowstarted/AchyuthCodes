package com.mateoj.multiactivitydrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Notify extends AppCompatActivity {


    TextView MSG;
    ArrayList<String> Notify_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);TextView MSG;

        MSG= (TextView) findViewById(R.id.not);




        Notify_list = new ArrayList<String>();

        ArrayHelper naveen = new ArrayHelper(this);







        //MSG= (TextView) findViewById(R.id.n0);
       // MSG1= (TextView) findViewById(R.id.n1);
        //MSG2= (TextView) findViewById(R.id.n2);
        //MSG3= (TextView) findViewById(R.id.n3);



      /*  SharedPreferences prefs = mContext.getSharedPreferences("preferencename", 0);
       // int size = prefs.getInt(arrayName + "_size", 0);
        String array[] = new String[size];
        for(int i=0;i<size;i++)
            array[i] = prefs.getString(arrayName + "_" + i, null);
        return array;
*/


        //Intent intent = getIntent();

        // String message = intent.getStringExtra(FirebaseMessagingService.EXTRA_MESSAGE);

        MSG.setText(naveen.getArray("Notif_Array").get(0));


        //  String message = intent.getStringExtra(FirebaseMessagingService.EXTRA_MESSAGE);

      //  MSG.setText(message);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hello! We will soon update this", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Intent intent = getIntent();
    }

}
