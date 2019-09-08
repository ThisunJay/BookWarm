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

public class viewWish extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wish);



    }

    public void onBack(View view){
        Intent intent = new Intent(viewWish.this,wishList.class);
        startActivity(intent);
    }
}
