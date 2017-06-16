package warrantree.upscale.warrantreeconsumer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import warrantree.upscale.warrantreeconsumer.DataModels.ItemCard;
import warrantree.upscale.warrantreeconsumer.Fragments.NavDrawerFragment;
import warrantree.upscale.warrantreeconsumer.RVs.RegisteredItemRVAdapter;

public class RegisteredItemsActivity extends AppCompatActivity {

    Intent toSharing, toAddItems, toClaims, toReminders, toServiceRequest, toProfile;

    private RecyclerView rvforItems;
    RegisteredItemRVAdapter rvforItemsAdapter;

    //Variables for RV
    private RecyclerView.LayoutManager myRegItemsRVLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_items);

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
        toClaims = new Intent(this, OngoingClaimsActivity.class);
        toReminders = new Intent(this, RemindersActivity.class);
        toServiceRequest = new Intent(this, ServiceRequestActivity.class);

        //Intent Linking ends here

        rvforItems = (RecyclerView) findViewById(R.id.registered_items_rv);
        rvforItems.setHasFixedSize(true);

        rvforItemsAdapter = new RegisteredItemRVAdapter(this, getItemData());

        rvforItems.setAdapter(rvforItemsAdapter);

        // use a linear layout manager
        myRegItemsRVLayoutManager = new LinearLayoutManager(RegisteredItemsActivity.this);
        rvforItems.setLayoutManager(myRegItemsRVLayoutManager);
    }
    public static List<ItemCard> getItemData() {  //This class assigns data to the RV for ItemCards
        //S0: Create a list object to hold the data but instantiate it using the superclass ArrayList
        List<ItemCard> mydata_rv_items = new ArrayList<>();

        //S1: Hardcoding the input data
        String[] list_card_name_label = {"Moto G4+", "Moto G4", "One Plus 5", "One Plus 3T", "One Plus 3"};
        String[] list_card_category = {"SmartPhone", "Mobile", "Smarterphone", "Phone", "Not so Smartphone"};
        String[] list_card_company = {"Moto | Lenovo", "Moto | Lenovo", "One Plus", "One Plus", "One Plus"};
        String[] list_card_warranty_stat = {"10 Days Remaining", "30 Days Remaining", "20 Days Remaining", "15 Days Remaining", "7 Days Remaining"};
        int[] list_card_item_image = {R.drawable.warrantree_logo, R.drawable.warrantree_logo, R.drawable.warrantree_logo, R.drawable.warrantree_logo, R.drawable.warrantree_logo};

        //S2: Create a for loop to add new items
        for (int i = 0; i < 50; i++) {
            //S2.a: Creating a new item of the ItemCard class
            ItemCard mycurrentItem = new ItemCard();

            //S2.b: Referencing the items of the class and putting values from the above arrays in them
            mycurrentItem.rv_data_item_name_label = list_card_name_label[i % list_card_name_label.length];
            mycurrentItem.rv_data_item_category = list_card_category[i %list_card_category.length];
            mycurrentItem.rv_data_item_company = list_card_company[i % list_card_company.length];
            mycurrentItem.rv_data_item_warranty_stat = list_card_warranty_stat[i % list_card_warranty_stat.length];
            mycurrentItem.rv_data_item_img_id = list_card_item_image[i % list_card_item_image.length];

            //S2.c: Adding the currentItem to the ArrayList object
            mydata_rv_items.add(mycurrentItem);
        }
        //S3: Return the List Object
        return mydata_rv_items;
    }
}
