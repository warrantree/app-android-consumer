package com.wintech.shoped.RVs;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.wintech.shoped.DataModels.ItemCard;

import java.util.Collections;
import java.util.List;

import warrantree.upscale.warrantreeconsumer.R;

/**
 * Created by Aditya on 6/8/2017.
 */

public class CardAdapter  extends RecyclerView.Adapter<CardAdapter.MyRVItemsViewHolder> {
    List<ItemCard> data_RV_events = Collections.emptyList();
    Context context;
    private LayoutInflater eventsrv_inflater;

    public CardAdapter(Context context, List<ItemCard> data_RV_events) {
        eventsrv_inflater = LayoutInflater.from(context);

        this.data_RV_events = data_RV_events;
    }

    @Override
    public CardAdapter.MyRVItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View my_eventsview = eventsrv_inflater.inflate(R.layout.rv_items_card, parent, false);

        CardAdapter.MyRVItemsViewHolder myeventsholder = new CardAdapter.MyRVItemsViewHolder(my_eventsview);
        Log.d("TTimz", "Inside onCreateViewHolder in EventsRV");
        return myeventsholder;
    }

    @Override
    public void onBindViewHolder(CardAdapter.MyRVItemsViewHolder holder, final int position) {
        ItemCard current_data = data_RV_events.get(position);

        holder.rv_item_name_label.setText(current_data.rv_data_item_name_label);
        holder.rv_item_category.setText(current_data.rv_data_item_category);
        holder.rv_item_company.setText(current_data.rv_data_item_company);
        holder.rv_item_warranty_stat.setText(current_data.rv_data_item_warranty_stat);
        holder.rv_item_image.setImageResource(current_data.rv_data_item_img_id);

        holder.rv_item_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TTimz", "Event Image clicked at" +position);
                Snackbar.make(view, "Event Image clicked at" +position, Snackbar.LENGTH_SHORT);
                //Toast.makeText(view, "Image clicked at" +position, Toast.LENGTH_SHORT);
            }
        });

/*        holder.rv_events_headline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TTimz", "Event Headline clicked at" +position);
                Snackbar.make(view, "Event Headline clicked at" +position, Snackbar.LENGTH_SHORT);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return data_RV_events.size();
    }

    class MyRVItemsViewHolder extends RecyclerView.ViewHolder{

        TextView rv_item_name_label, rv_item_category, rv_item_company, rv_item_warranty_stat;
        ImageView rv_item_image;
        ImageButton rv_item_ib_remind, rv_item_ib_share, rv_item_ib_claim, rv_item_ib_offer;

        public MyRVItemsViewHolder(View itemView) {
            super(itemView);
            rv_item_name_label = (TextView) itemView.findViewById(R.id.rv_tv_ProductName);
            rv_item_category = (TextView) itemView.findViewById(R.id.rv_tv_ProductCategory);
            rv_item_company = (TextView) itemView.findViewById(R.id.rv_tv_CompanyName);
            rv_item_warranty_stat = (TextView) itemView.findViewById(R.id.rv_tv_warranty_status);
            rv_item_image = (ImageView) itemView.findViewById(R.id.rv_item_image);
            rv_item_ib_remind = (ImageButton) itemView.findViewById(R.id.rv_btn_remind);
            rv_item_ib_share = (ImageButton) itemView.findViewById(R.id.rv_btn_share);
            rv_item_ib_claim = (ImageButton) itemView.findViewById(R.id.rv_btn_claim);
            rv_item_ib_offer = (ImageButton) itemView.findViewById(R.id.rv_btn_offer);

            rv_item_ib_offer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Showing Offers for #" + getLayoutPosition(), Snackbar.LENGTH_SHORT).show();
                }
            });
            rv_item_ib_remind.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Setting Reminder for #" + getLayoutPosition(), Snackbar.LENGTH_SHORT).show();
                }
            });
            rv_item_ib_claim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Claiming Warranty for #" + getLayoutPosition(), Snackbar.LENGTH_SHORT).show();
                }
            });
            rv_item_ib_share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Sharing Product #" + getLayoutPosition(), Snackbar.LENGTH_SHORT).show();
                }
            });
        }

        /*@Override
        public void onClick(View view) {
            Snackbar.make(view, "Image Button clicked at" + getLayoutPosition(), Snackbar.LENGTH_SHORT).show();
            //Toast.makeText(, "News Image Clicked! @ #", Toast.LENGTH_SHORT).show();

            //Step 16.c: Use the context variable created in setp 16.a to reference and start the activity
            context.startActivity(new Intent(context, RemindersActivity.class));
        }*/
    }
}
