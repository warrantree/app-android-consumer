package com.mate.android.warrantee.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mate.android.warrantee.R;
import com.mate.android.warrantee.models.Product;

import java.util.ArrayList;

/**
 * Created by anujgupta on 28/04/17.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.Products>{


    ArrayList<Product> products = new ArrayList<>();
    Context context;

    public ProductsAdapter(Context context,ArrayList<Product> products) {
        this.products = products;
        this.context = context;
    }

    @Override
    public Products onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(context).inflate(R.layout.card_product,parent,false);
        Products p = new Products(v);
        return p;
    }

    @Override
    public void onBindViewHolder(Products holder, int position) {

        holder.ivProd.setImageResource(R.mipmap.ic_launcher);
        holder.tvProdName.setText(products.get(position).getName());
        holder.tvProdBrand.setText(products.get(position).getBrand());
        holder.tvProdSerialNo.setText(products.get(position).getSerial_no());
        holder.tvProdWarranty.setText(products.get(position).getWarranty());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class Products extends RecyclerView.ViewHolder{

        ImageView ivProd;
        TextView tvProdName;
        TextView tvProdBrand;
        TextView tvProdSerialNo;
        TextView tvProdWarranty;

        public Products(View v) {
            super(v);

            ivProd = (ImageView) v.findViewById(R.id.ivProduct);
            tvProdName = (TextView) v.findViewById(R.id.tvProdName);
            tvProdBrand = (TextView) v.findViewById(R.id.tvProdBrand);
            tvProdSerialNo = (TextView) v.findViewById(R.id.tvProdSerialNo);
            tvProdWarranty = (TextView) v.findViewById(R.id.tvProdWarranty);

        }
    }
}
