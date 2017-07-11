package com.mateoj.multiactivitydrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class InfoRep extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_rep);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


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

}
