package com.mate.android.warrantee.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mate.android.warrantee.R;

public class MobileVerificationActivity extends AppCompatActivity implements View.OnClickListener {


    Button btVerify,btSubmitOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_verification);

        btVerify = (Button) findViewById(R.id.btVerifyMobileNo);
        btSubmitOTP = (Button) findViewById(R.id.btSubmitOTP);

        btSubmitOTP.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btSubmitOTP:

                startActivity(new Intent(MobileVerificationActivity.this,SignUpActivity.class));

                break;

        }
    }
}
