package com.mate.android.warrantee.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mate.android.warrantee.R;
import com.mate.android.warrantee.activities.MainActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    Button btSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btSignUp = (Button) findViewById(R.id.btSubmitSignUp);
        btSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.btSubmitSignUp:

                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));

                break;

        }
    }
}
