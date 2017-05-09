package com.mate.android.warrantee.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mate.android.warrantee.R;

/**
 * Created by anujgupta on 03/05/17.
 */

public class AlertsAdapter extends RecyclerView.Adapter<AlertsAdapter.Alert>{

    Context context;


    public AlertsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Alert onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_alerts,parent,false);
        Alert a = new Alert(v);
        return a;
    }

    @Override
    public void onBindViewHolder(Alert holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class Alert extends RecyclerView.ViewHolder{


        public Alert(View itemView) {
            super(itemView);
        }
    }

}
