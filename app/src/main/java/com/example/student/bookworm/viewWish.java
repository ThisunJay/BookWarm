package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import Adapters.WishAdapter;
import Database.DBHandler;
import Model.WishList;

public class viewWish extends AppCompatActivity {
    String Title,price;
    TextView txt_title,txt_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wish);

        Intent intent = getIntent();

        Title = intent.getStringExtra("TITLE");
        price = intent.getStringExtra("PRICE");
        txt_title = findViewById(R.id.ttv35);
        txt_price = findViewById(R.id.ttv36);

        txt_title.setText(Title);
        txt_price.setText(price);
    }

    public void onBack(View view){
        Intent intent = new Intent(viewWish.this,wishList.class);
        startActivity(intent);
    }
}
