package pavan.com.letsthread;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    ProgressBar bar,bar1;
    TextView label;
    int status=0,sts=2;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        bar = (ProgressBar) findViewById(R.id.progressBar);

        bar1 = (ProgressBar) findViewById(R.id.progressBar1);

        label = (TextView) findViewById(R.id.textView);



        new Thread(new Runnable() {
            @Override
            public void run() {
                while(sts<200){
                    sts=sts+7;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            bar.setProgress(sts);
                           // label.setText(String.valueOf(sts));
                        }
                    });


                }
            }
        }).start();



        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while(status<100){

                        status = status + 8;


                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                bar1.setProgress(status);
                                label.setText(String.valueOf(sts));
                            }
                        });

                    }

                    }
                }).start();


            }
        });
    }


}
