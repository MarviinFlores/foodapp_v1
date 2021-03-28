package com.example.orderingfood.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.orderingfood.FoodDetails;
import com.example.orderingfood.R;

import java.util.List;

import Model.Allmenu;

public class AllMenuAdapter extends RecyclerView.Adapter< AllMenuAdapter.AllMenuViewHolder> {
    Context context;
    List <Allmenu> allmenuList;

    public AllMenuAdapter(Context context, List<Allmenu> almenuList) {
        this.context = context;
        this.allmenuList = almenuList;
    }

    @NonNull
    @Override
    public AllMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.allmenu_recycler_items,parent,false);
        return new AllMenuViewHolder(view);
    }

    @Override 
    public void onBindViewHolder(@NonNull AllMenuViewHolder holder, final int position) {
        // PARSING DATA
        holder.popularName.setText(allmenuList.get(position).getName());
        holder.popularNote.setText(allmenuList.get(position).getNote());
        holder.popularCharges.setText(allmenuList.get(position).getDeliveryCharges());
        holder.popularRating.setText(allmenuList.get(position).getRating());
        holder.popularTime.setText(allmenuList.get(position).getDeliveryTime());
        holder.popularPrice.setText(allmenuList.get(position).getPrice());

        // PARSING IMAGE

        Glide.with(context).load(allmenuList.get(position).getImageUrl()).into(holder.popularImage);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(context, FoodDetails.class);
                i.putExtra("name", allmenuList.get(position).getName());
                i.putExtra("price", allmenuList.get(position).getPrice());
                i.putExtra("rating", allmenuList.get(position).getRating());
                i.putExtra("image", allmenuList.get(position).getImageUrl());

                context.startActivity(i);

            }
        });






    }

    @Override
    public int getItemCount() {
        return  allmenuList.size();
    }

    public  static class AllMenuViewHolder  extends RecyclerView.ViewHolder{

        TextView popularName, popularNote, popularRating,popularTime,popularCharges,popularPrice;
        ImageView popularImage;



        public AllMenuViewHolder(@NonNull View itemView) {

            super(itemView);
            popularName = itemView.findViewById(R.id.popular_name);
            popularNote = itemView.findViewById(R.id.popular_note);
            popularCharges = itemView.findViewById(R.id.popular_delivery_charge);
            popularRating = itemView.findViewById(R.id.popular_rating);
            popularTime = itemView.findViewById(R.id.popular_deliverytime);
            popularPrice = itemView.findViewById(R.id.popular_price);
            popularImage = itemView.findViewById(R.id.popular_image);
        }
    }
}
