package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddToWishlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_wishlist);
    }

    public void viewWishList(View view){
        Intent intent = new Intent(AddToWishlist.this, wishList.class);
        startActivity(intent);
    }
}
