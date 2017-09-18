package com.wintech.shoped;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import warrantree.upscale.warrantreeconsumer.R;

public class UserLoginActivity extends AppCompatActivity {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    int resendOTP_count = 0;
    Button loginAct_btn_sendOTP, loginAct_btn_submitOTP, loginAct_btn_skiptohome;
    EditText loginAct_et_usr_mobnum, loginAct_et_usr_otp;
    TextInputLayout loginAct_et_usr_mobnum_lay, loginAct_et_usr_otp_lay;
    TextView loginAct_tv_otp_hint;
    Boolean loginAct_usr_OTP_success;
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        /*//Linking button to their views
        loginAct_btn_skiptohome = (Button) findViewById(R.id.login_btn_skip_to_home);
        loginAct_btn_sendOTP = (Button) findViewById(R.id.login_btn_send_otp);
        loginAct_btn_submitOTP = (Button) findViewById(R.id.login_btn_submit_otp);

        //Botton Linking Ends here

        //Linking TextInputLayouts and Corresponding EditTexts + Text Views
        loginAct_et_usr_mobnum_lay = (TextInputLayout) findViewById(R.id.login_et_usr_mobnum_lay);
        loginAct_et_usr_mobnum = (EditText) findViewById(R.id.login_et_usr_mobnum);
        loginAct_et_usr_otp_lay = (TextInputLayout) findViewById(R.id.login_et_usr_otp_lay);
        loginAct_et_usr_otp = (EditText) findViewById(R.id.login_et_usr_otp);

        //TextViews
        loginAct_tv_otp_hint = (TextView) findViewById(R.id.login_tv_otp_hint);
        //TIP and ET Linking Ends here

        //Linking Buttons to click Listeners
//        loginAct_btn_sendOTP.setOnClickListener();
        //Button Kinking Ends Here*/
    }

    //All button clicks are handled together in this function
    public void buttonOnClick(View view)
    {
        switch(view.getId())
        {
            case R.id.login_btn_send_otp:
                String usr_MobNum = loginAct_et_usr_mobnum_lay.getEditText().getText().toString();
                if (!validateMobNum(usr_MobNum)) {
                    loginAct_et_usr_mobnum_lay.setErrorTextAppearance(R.style.AppTheme);
                    loginAct_et_usr_mobnum_lay.setError("Not a valid Mobile Number! Check before sending OTP");
                } else {
                    loginAct_et_usr_mobnum_lay.setErrorEnabled(false);
                    //Checking if OTP sent succesfully.
                    loginAct_usr_OTP_success = sendOTP();
                    onSendOTP();
                }
                // TODO: API calls for checking if number exists in DB goes here
                break;

            case R.id.login_btn_submit_otp:
                String currentOTP = loginAct_et_usr_otp_lay.getEditText().getText().toString();
                if (!validateOTP(currentOTP)) {
                    loginAct_et_usr_otp_lay.setError("Not a valid OTP!");
                    resendOTP();
                } else {
                    loginAct_et_usr_otp_lay.setErrorEnabled(false);
                    completeLogin();
                }
                // TODO: API calls for submitting OTP goes here

                // TODO: Make elements invisible once OTP based auth is done.
                //onSubmitOTP();
                break;
/*
            case R.id.login_btn_skip_to_home:
                toHome();
                //startActivity(new Intent(UserLoginActivity.this, HomeActivity.class));
                // Code for button 2 click
                break;*/
        }
    }

    public void disableEditText(EditText et) {
        //et.setFocusable(false);
        et.setEnabled(false);
    }

    //To Enable an EditTextView
    public void enableEditText(EditText et) {
        et.setEnabled(true);
        //et.setFocusable(true);
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    //Method to validate emails using the regular expression fetched from wikipedia
    //Corresponding ariables are on top of the class file.
    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validateMobNum(String mobnum) {
        return mobnum.length() == 10;
    }

    public boolean validateOTP(String currentotp) {
        return currentotp.length() == 6;
    }

    public Boolean sendOTP() {
        Toast.makeText(getApplicationContext(), "OTP Sent! Check your SMS for the 6-digit OTP!.", Toast.LENGTH_SHORT).show();
        // TODO: login procedure;

        return true;
    }

    public void completeLogin() {
        Toast.makeText(getApplicationContext(), "Woohoo! Authentication was successful!.", Toast.LENGTH_SHORT).show();
        // TODO: login procedure;
    }

    /*public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rb_gst:
                if (checked)
                    et_ShopVATGSTlay.getEditText().setHint("GST");
                break;
            case R.id.rb_vat:
                if (checked)
                    et_ShopVATGSTlay.getEditText().setHint("VAT");
                break;
            case R.id.rb_tin:
                if (checked)
                    et_ShopVATGSTlay.getEditText().setHint("TIN");
                break;
            case R.id.rb_pan:
                if (checked)
                    et_ShopVATGSTlay.getEditText().setHint("PAN");
                break;
        }
    }*/

    public void onSendOTP() {
        //Show Next Section
        loginAct_et_usr_otp_lay.setVisibility(View.VISIBLE);
        loginAct_btn_submitOTP.setVisibility(View.VISIBLE);
        //ib_enableedit.setVisibility(View.VISIBLE);
        disableEditText(loginAct_et_usr_mobnum);

        //Hide Previous Section
        loginAct_btn_sendOTP.setVisibility(View.GONE);
    }

    /*public void onSubmitOTP() {

        //Show Next Section
        et_ShopNamelay.setVisibility(View.VISIBLE);
        et_ShopEmaillay.setVisibility(View.VISIBLE);
        et_ShopEmployeeNamelay.setVisibility(View.VISIBLE);
        et_ShopVATGSTlay.setVisibility(View.VISIBLE);
        radiogroup_for_shop_auth_id.setVisibility(View.VISIBLE);
        bt_submitDetails.setVisibility(View.VISIBLE);

        //Hide Previous Section
        et_OTPlay.setVisibility(View.GONE);
        tv_edithint.setVisibility(View.GONE);
        //ib_enableedit.setVisibility(View.GONE);
        bt_submitOTP.setVisibility(View.GONE);
        tv_header.setText("Business/Shop Details");
    }

    public void onSubmitDetails() {
        //Show Next Section
        et_ShopAddresslay.setVisibility(View.VISIBLE);
        et_ShopAddressCitylay.setVisibility(View.VISIBLE);
        et_ShopAddressStatelay.setVisibility(View.VISIBLE);
        et_ShopAddressZIPlay.setVisibility(View.VISIBLE);
        bt_submitAddress.setVisibility(View.VISIBLE);

        //Hide Previous Section
        et_ShopNamelay.setVisibility(View.GONE);
        et_ShopEmaillay.setVisibility(View.GONE);
        et_ShopName.setVisibility(View.GONE);
        et_ShopVATGSTlay.setVisibility(View.GONE);
        et_ShopEmployeeNamelay.setVisibility(View.GONE);
        radiogroup_for_shop_auth_id.setVisibility(View.GONE);
        bt_submitDetails.setVisibility(View.GONE);
    }

    public void onSubmitAddress() {

        //Hide Current Section
        et_ShopAddresslay.setVisibility(View.GONE);
        et_ShopAddressCitylay.setVisibility(View.GONE);
        et_ShopAddressStatelay.setVisibility(View.GONE);
        et_ShopAddressZIPlay.setVisibility(View.GONE);
        bt_submitAddress.setVisibility(View.GONE);

        //Show the Next Section
        //TODO: Add Succesful Completion Screen


        //Start New Activity
        startActivity(new Intent(UserLogin.this, Home.class));
    }*/

    public void resendOTP() {
        if (resendOTP_count >= 2) {
            enableEditText(loginAct_et_usr_mobnum);

            //Show Previous Section
            loginAct_btn_sendOTP.setVisibility(View.VISIBLE);

            //Hide Current Section
            loginAct_btn_submitOTP.setVisibility(View.GONE);
            loginAct_et_usr_otp_lay.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(), "Attention! Max OTP Count Reached!", Toast.LENGTH_SHORT).show();
            loginAct_tv_otp_hint.setText(R.string.otp_resend_02);
        } else {
            resendOTP_count++;
        }
        Toast.makeText(getApplicationContext(), "OTP Re-Sent! Check your messages for the 6-digit OTP!.", Toast.LENGTH_SHORT).show();
    }

    public void toHome() {
        startActivity(new Intent(UserLoginActivity.this, HomeActivity.class));
    }
}
