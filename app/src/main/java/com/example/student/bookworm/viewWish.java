package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import Database.DBHandler;
import Model.WishList;


public class viewWish extends AppCompatActivity {
    private ArrayList<WishList> WarrayList;
    WishList wishList;
    TextView txt_title,txt_p,Total;
    EditText txt_price;
    DBHandler db;
    String Title,Price,Author,ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wish);

        Intent intent = getIntent();
        wishList = (WishList) intent.getSerializableExtra("Wishlist");

        db = new DBHandler(this);

        txt_title = findViewById(R.id.ttv35);

        txt_p = findViewById(R.id.tv18);
        txt_price = findViewById(R.id.tp1);
        Button editBtn = findViewById(R.id.editbtn);
        Button done = findViewById(R.id.kaviSave);

        txt_title.setText(wishList.getTitle());

        //txt_price.setText(String.valueOf( wishList.getPrice() ));
        txt_p.setText(String.valueOf(wishList.getPrice()));

        Total = findViewById(R.id.tv18);
        db = new DBHandler(this);
        ArrayList<WishList> WarrayList = db.readAllWishList();
        //Total.setText("RS" + getTotal(wishList));

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(viewWish.this, EditWish.class);
                //Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
                inte.putExtra("title", wishList.getTitle());
                inte.putExtra("author", wishList.getAuthor());
                inte.putExtra("price", String.valueOf(wishList.getPrice()));
                inte.putExtra("id", String.valueOf(wishList.getId()));
                startActivity(inte);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = String.valueOf(wishList.getId());
                //Toast.makeText(getApplicationContext(),txt_price.getText().toString(), Toast.LENGTH_LONG).show();
                Double price = wishList.getPrice() - Double.valueOf(txt_price.getText().toString());
                boolean boo = db.WishUpdate(id, wishList.getTitle(), wishList.getAuthor(), price);
                if(boo == true){
                    Intent inte = new Intent(viewWish.this, wishList.class);
                    Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
                    startActivity(inte);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void onBack(View view){
        Intent intent = new Intent(viewWish.this,wishList.class);
        startActivity(intent);
    }


}
