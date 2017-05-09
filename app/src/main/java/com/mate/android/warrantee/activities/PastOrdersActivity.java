package com.mate.android.warrantee.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.mate.android.warrantee.R;
import com.mate.android.warrantee.adapters.OrdersAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class PastOrdersActivity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.Adapter adapter;
    LinearLayoutManager llm;
    ArrayList<String> bills = new ArrayList<>(Arrays.asList("bill1","bill1","bill1","bill1"));
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_orders);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rv = (RecyclerView) findViewById(R.id.rvPastOrders);
        llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        adapter = new OrdersAdapter(bills,this);
        rv.setAdapter(adapter);

    }
}
