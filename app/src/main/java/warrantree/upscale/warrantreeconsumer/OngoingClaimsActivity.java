package warrantree.upscale.warrantreeconsumer;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class OngoingClaimsActivity extends AppCompatActivity {

    Intent toSharing, toAddItems, toReminders, toRegistered, toServiceRequest, toProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing_claims);

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

        //Intent Linking starts here
        toSharing = new Intent(this, SharingActivity.class);
        toAddItems = new Intent(this, AddItemsActivity.class);
        toProfile = new Intent(this, UserProfileActivity.class);
        toReminders = new Intent(this, RemindersActivity.class);
        toRegistered = new Intent(this, RegisteredItemsActivity.class);
        toServiceRequest = new Intent(this, ServiceRequestActivity.class);

        //Intent Linking ends here
    }
}
