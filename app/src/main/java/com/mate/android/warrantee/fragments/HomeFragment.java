package com.mate.android.warrantee.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mate.android.warrantee.R;
import com.mate.android.warrantee.activities.AlertActivity;
import com.mate.android.warrantee.activities.ProductListActivity;

import java.io.ByteArrayOutputStream;

/**
 * Created by anujgupta on 23/04/17.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    FloatingActionButton fabAddDevice;
    CardView cvDevices,cvAlert,cvClaims,cvProdShared;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);

        fabAddDevice = (FloatingActionButton) v.findViewById(R.id.fabAddProduct);
        fabAddDevice.setOnClickListener(this);

        cvDevices = (CardView) v.findViewById(R.id.cvDevices);
        cvAlert = (CardView) v.findViewById(R.id.cvAlert);
        cvClaims = (CardView) v.findViewById(R.id.cvClaims);
        cvProdShared = (CardView) v.findViewById(R.id.cvProdShared);


        cvDevices.setOnClickListener(this);
        cvAlert.setOnClickListener(this);
        cvClaims.setOnClickListener(this);
        cvProdShared.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){


            case R.id.fabAddProduct:

                Toast.makeText(getActivity(),"Fab",Toast.LENGTH_SHORT).show();
                break;

            case R.id.cvDevices:
                Toast.makeText(getActivity(),"Devices",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), ProductListActivity.class));
                break;

            case R.id.cvAlert:
                Toast.makeText(getActivity(),"Alert",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), AlertActivity.class));
                break;

            case R.id.cvClaims:
                Toast.makeText(getActivity(),"Claims",Toast.LENGTH_SHORT).show();
                break;

            case R.id.cvProdShared:
                Toast.makeText(getActivity(),"Shared",Toast.LENGTH_SHORT).show();
                break;

        }


    }


}
