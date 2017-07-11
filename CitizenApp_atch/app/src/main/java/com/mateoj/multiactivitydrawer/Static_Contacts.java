package com.mateoj.multiactivitydrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class Static_Contacts extends BaseActivity {


    private List<contacts> persons;

    int i= R.drawable.call_1;

    ScrollView scrollView;



    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static__contacts);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        assert mRecyclerView != null;
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        if(message.equals("EmergCon")){  EmergencyContacts();}

        else if(message.equals("PoliceStat")){ PoliceContacts();}


        mAdapter = new MyAdapter(persons);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void PoliceContacts(){
        persons = new ArrayList<>();
        persons.add(new contacts("Commissioner office", "0253-2305200/2305201", i));

        persons.add(new contacts("DCP headquarter office", "0253-2305205", i));

        persons.add(new contacts("Control Room", "0253-2305233", i));
        persons.add(new contacts("Crime Branch", "253-  2392233 / 2393341", i));
        persons.add(new contacts("City Traffic Branch", "0253-2305228", i));
        persons.add(new contacts("Nashik city police", "0253 2305233", i));

        persons.add(new contacts("Mahila Suraksha Vishesh Shakha", "0253-2305241",i));

        persons.add(new contacts("Economic Offence Wing", "0253-2305230", i));

        persons.add(new contacts("Adagon Police Station", "0253-2629837 ", i));
        persons.add(new contacts("Ambad Police Station", "0253-2392233 / 2393341", i));




        persons.add(new contacts("Bhadrakali Police Station", "0253-2305254 / 2305255 / 2305267", i));

        persons.add(new contacts("Deolali Police Station", "0253-2491233", i));

        persons.add(new contacts("Gangapur Police Station", "0253-2305242",i));

        persons.add(new contacts("Indira Nagar Police Station", "0253-2397733", i));
        persons.add(new contacts("Mhasrul Police Station ", "0253 262 9830", i));

        persons.add(new contacts("Mumbai Naka", "0253 259 3300", i));
        persons.add(new contacts("Nashik Road Police Station", "0253-2465533 / 2465133", i));
        persons.add(new contacts("Panchvati Police Station", "0253-2629831 / 2629830", i));


        persons.add(new contacts("Sarkarwada Police Station", "0253-2305214 / 2305225", i));

        persons.add(new contacts("Satpur Police Station", "0253-2305237 / 2305238", i));
        persons.add(new contacts("Upnagar Police Station", "0253 2305205", i));

    }

    private void EmergencyContacts(){
        persons = new ArrayList<>();
        persons.add(new contacts("Police", "100", i));
        persons.add(new contacts("Fire", "101", i));
        persons.add(new contacts("Ambulance", "108", i));
        persons.add(new contacts("Gas leakage", "1906",i));
        persons.add(new contacts("Blood requirement", "0253-2305230 / 104", i));
        persons.add(new contacts("Women helpline", "181", i));
        persons.add(new contacts("Child helpline", "1098", i));
        persons.add(new contacts("Nashik city Police", "181", i));
        persons.add(new contacts("Police WhatsApp number", "9075011222", i));

      /*  persons.add(new contacts("Bhadrakali Police Station", "0253-2305254 / 2305255 / 2305267", i));
        persons.add(new contacts("Sarkarwada Police Station", "0253-2305214 / 2305225", i));
        persons.add(new contacts("Gangapur Police Station", "0253-2305242",i));
        persons.add(new contacts("Adagon Police Station", "0253-2629837 ", i));
        persons.add(new contacts("Ambad Police Station", "0253-2392233 / 2393341", i));
*/
    }

/*
 @Override
    protected boolean useToolbar() {
        return false;
    }

    @Override
    protected boolean useDrawerToggle() {
        return false;
    }
*/


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
}