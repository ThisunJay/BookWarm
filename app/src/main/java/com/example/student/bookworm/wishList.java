package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class wishList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
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
}
