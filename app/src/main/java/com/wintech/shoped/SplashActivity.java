package com.wintech.shoped;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import warrantree.upscale.warrantreeconsumer.R;

public class SplashActivity extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = (ImageView) findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                //startActivity(new Intent(SplashActivity.this, UserLoginActivity.class));
                //startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                //finish();
            }
        });

        // Create a Timer
        Timer RunSplash = new Timer();

        // Task to do when the timer ends
        TimerTask ShowSplash = new TimerTask() {
            @Override
            public void run() {

                // Start MainActivity.class

                /* Intent splashToOnboarding = new Intent(Splash.this, OnBoard.class);
                 startActivity(splashToOnboarding);*/
                startActivity(new Intent(SplashActivity.this, UserLoginActivity.class));
                //startActivity(new Intent(SplashActivity.this, UserLoginActivity.class));

                // Close SplashScreenActivity.class
                //finish();

            }
        };

        // Start the timer
        // Set Duration of the Splash Screen(in milisecs)
        RunSplash.schedule(ShowSplash, 2000);
    }
}
