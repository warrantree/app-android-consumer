package com.wintech.shoped;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.wintech.shoped.Fragments.NavDrawerFragment;

import warrantree.upscale.warrantreeconsumer.R;

public class HomeActivity extends AppCompatActivity {

    Intent toSharing, toAddItems, toClaims, toReminders, toRegistered, toServiceRequest, toProfile;
    FloatingActionButton homeAct_fab_registered, homeAct_fab_remind, homeAct_fab_share, homeAct_fab_claim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_home_toolbar);
        setSupportActionBar(my_toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavDrawerFragment mydrawerfragment = (NavDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.frag_nav_drawer);

        //To set up the custom navigation drawer we need to pass the following arguments:
        // 1. ID of the fragment tab in the main activity
        // 2. TypeCasted drawerlayout as we defined in the layouts with the fragment's layout
        // 3. variable reference to the toolbar we intend to use with in the activity with the nav drawer
        // These will be passed through a function which shall be defined in a seperate fragment file, Example "setUp();"
        mydrawerfragment.setUp(R.id.frag_nav_drawer, (DrawerLayout) findViewById(R.id.my_drawer_layout), my_toolbar);

        //mydrawerfragment.setNavigationItemSelectedListener(this);

        //Intent Linking starts here
        toSharing = new Intent(HomeActivity.this, SharingActivity.class);
        toAddItems = new Intent(HomeActivity.this, AddItemsActivity.class);
        toProfile = new Intent(HomeActivity.this, UserProfileActivity.class);
        toClaims = new Intent(HomeActivity.this, OngoingClaimsActivity.class);
        toReminders = new Intent(HomeActivity.this, RemindersActivity.class);
        toRegistered = new Intent(HomeActivity.this, RegisteredItemsActivity.class);
        toServiceRequest = new Intent(HomeActivity.this, ServiceRequestActivity.class);

        //Intent Linking ends here

        //Button Linking starts here
        homeAct_fab_registered = (FloatingActionButton) findViewById(R.id.home_fab_add_product);
        homeAct_fab_claim = (FloatingActionButton) findViewById(R.id.home_fab_add_claims);
        homeAct_fab_remind = (FloatingActionButton) findViewById(R.id.home_fab_add_reminder);
        homeAct_fab_share = (FloatingActionButton) findViewById(R.id.home_fab_share_item);

        //Button Linking ends here
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_user_profile:
                startActivity(toProfile);
                // User chose the "Settings" item, show the app settings UI...
                //startActivity(new Intent(this, ProfileActivity.class));
                return true;

            case R.id.action_claims:
                startActivity(toClaims);
                // User chose the "Favorite" action, mark the current item
                //startActivity(new Intent(this, CRMActivity.class));
                // as a favorite...
                return true;

            case R.id.action_share:
                startActivity(toSharing);
                //btnRateAppOnClick(item);
                return true;

            case R.id.action_reminder:
                startActivity(toReminders);
                //btnRateAppOnClick(item);
                return true;

            case R.id.action_addprod:
                startActivity(toAddItems);
                //btnRateAppOnClick(item);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }

    }

    //All card clicks are handled together in this function
    public void cardOnClick(View view) {
        switch (view.getId()) {
            case R.id.home_fab_add_product:
                startActivity(toAddItems);
                break;
            case R.id.home_fab_add_reminder:
                startActivity(toReminders);
                break;
            case R.id.home_fab_add_claims:
                startActivity(toServiceRequest);
                break;
            case R.id.home_fab_share_item:
                startActivity(toSharing);
                break;
            case R.id.home_tv_reg_products:
                startActivity(toRegistered);
                break;
            case R.id.home_tv_claims:
                startActivity(toClaims);
                break;
            case R.id.home_tv_shared:
                startActivity(toSharing);
                break;
            default:
                Snackbar.make(view, "Button has no linked functions or actions", Snackbar.LENGTH_SHORT).show();
                break;
        }
    }
}
