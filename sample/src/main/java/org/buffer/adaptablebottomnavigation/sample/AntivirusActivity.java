package org.buffer.adaptablebottomnavigation.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.glomadrian.dashedcircularprogress.DashedCircularProgress;

/**
 * Created by md.tanvirsaad on 8/31/17.
 */


public class AntivirusActivity extends AppCompatActivity {

   // private Button restartButton;
    private DashedCircularProgress dashedCircularProgress;
    private TextView numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antivirus);


     //   restartButton = (Button) findViewById(R.id.restart);
        dashedCircularProgress = (DashedCircularProgress) findViewById(R.id.simple);
        numbers = (TextView) findViewById(R.id.number);
        animate();
/*
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restart();
            }
        });*/

        dashedCircularProgress.setOnValueChangeListener(
                new DashedCircularProgress.OnValueChangeListener() {
                    @Override
                    public void onValueChange(float value) {
                        numbers.setText((int) value + "%");
                    }
                });




    }

    private void restart() {
        dashedCircularProgress.reset();
        animate();
    }

    private void animate() {
        dashedCircularProgress.setValue(100);
        dashedCircularProgress.setDuration(7000);
        dashedCircularProgress.setExternalColor(getResources().getColor(R.color.black));
        dashedCircularProgress.setInternalBaseColor(getResources().getColor(R.color.blue));
        dashedCircularProgress.setProgressColor(getResources().getColor(R.color.white_40));
     //   dashedCircularProgress.set


    }
}
