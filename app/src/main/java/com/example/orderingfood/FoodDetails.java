package com.example.orderingfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FoodDetails extends AppCompatActivity {


    // setting DATA from Intent to UI
        ImageView imageView;
        TextView itemName, itemPrice, itemRating;
        String name ,price , rating ,imageURL;
        RatingBar ratingBar;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        Intent intent =  getIntent();

        name = intent.getStringExtra(name="name");
        price = intent.getStringExtra(name="price");
        rating = intent.getStringExtra(name="rating");
        imageURL = intent.getStringExtra(name="image");

            imageView = findViewById(R.id.imageView4);
            itemName = findViewById(R.id.name);
            itemPrice = findViewById(R.id.price);
            itemRating = findViewById(R.id.rating);
            ratingBar = findViewById(R.id.ratingBar);


            Glide.with(getApplicationContext()).load(imageURL).into(imageView);

            itemName.setText(name);
            itemPrice.setText(price);
            itemRating.setText(rating);
            ratingBar.setRating(Float.parseFloat(rating));



        }
}