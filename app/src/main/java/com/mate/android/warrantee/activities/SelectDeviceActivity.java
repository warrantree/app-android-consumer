package com.mate.android.warrantee.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mate.android.warrantee.R;

public class SelectDeviceActivity extends AppCompatActivity {

    RecyclerView rvDevices;
    RecyclerView.Adapter adapter;
    GridLayoutManager glm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_device);
    }
}
