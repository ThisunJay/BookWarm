package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import Adapters.WishAdapter;
import Database.DBHandler;
import Model.WishList;

public class wishList extends AppCompatActivity {
    private ArrayList<WishList> arrayList;
    DBHandler db;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
//
        db = new DBHandler(this);
        rv = findViewById(R.id.recycle1);
        rv.setLayoutManager( new LinearLayoutManager(this));

        ArrayList<WishList> arrayList =  db.readAllWishList();
        WishAdapter adapter  = new WishAdapter(arrayList);
        rv.setAdapter(adapter);
    }

    public void viewWish(View view){
        Intent intent = new Intent(wishList.this, viewWish.class);
        startActivity(intent);
    }

    public void addtowish(View view){
        Intent intent = new Intent(wishList.this, AddToWishlist.class);
        startActivity(intent);
    }

    public void onBack(View view){
        Intent intent = new Intent(wishList.this, MainActivity.class);
        startActivity(intent);
    }

    public void OnWishinClick(int position){
        arrayList.get(position);
        Intent intent = new Intent(this,viewWish.class);
        startActivity(intent);
    }
}
