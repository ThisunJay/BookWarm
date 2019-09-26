package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Model.WishList;


public class viewWish extends AppCompatActivity {
    WishList wishList;
    TextView txt_title,txt_price,txt_author;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wish);

        Intent intent = getIntent();
        wishList = (WishList) intent.getSerializableExtra("Wishlist");


        txt_title = findViewById(R.id.ttv35);

        txt_price = findViewById(R.id.tv18);
        Button editBtn = findViewById(R.id.editbtn);
        Button done = findViewById(R.id.kaviSave);

        txt_title.setText(wishList.getTitle());

        txt_price.setText(String.valueOf( wishList.getPrice() ));

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewWish.this,EditWishList.class);
                intent.putExtra("Wishlist",wishList );
                startActivity(intent);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void onBack(View view){
        Intent intent = new Intent(viewWish.this,wishList.class);
        startActivity(intent);
    }



}
