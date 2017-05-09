package com.mate.android.warrantee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mate.android.warrantee.auth.LoginActivity;
import com.mate.android.warrantee.auth.MobileVerificationActivity;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    startActivity(new Intent(SplashActivity.this,MobileVerificationActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        t.start();
    }
}
