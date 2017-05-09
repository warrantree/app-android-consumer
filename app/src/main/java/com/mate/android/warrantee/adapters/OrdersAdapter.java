package com.mate.android.warrantee.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.mate.android.warrantee.R;

import java.util.ArrayList;

/**
 * Created by anujgupta on 23/04/17.
 */

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.Orders>{


    ArrayList<String> bill = new ArrayList<>();
    Context context;

    public OrdersAdapter(ArrayList<String> bill, Context context) {
        this.bill = bill;
        this.context = context;
    }

    @Override
    public Orders onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(context).inflate(R.layout.card_past_orders,parent,false);
        Orders o = new Orders(v);
        return o;
    }

    @Override
    public void onBindViewHolder(Orders holder, int position) {

        holder.ivBillImage.setImageResource(R.drawable.bill);
    }

    @Override
    public int getItemCount() {
        return bill.size();
    }

    public class Orders extends RecyclerView.ViewHolder{

        ImageView ivBillImage;
        TextView tvBillId;
        TextView tvProductName;
        TextView tvCustNum;

        public Orders(View v) {
            super(v);

            ivBillImage = (ImageView) v.findViewById(R.id.ivBillImage);
            tvBillId = (TextView) v.findViewById(R.id.tvBillId);
            tvProductName = (TextView) v.findViewById(R.id.tvProductName);
            tvCustNum = (TextView) v.findViewById(R.id.tvCustomerNumber);

        }
    }
}
