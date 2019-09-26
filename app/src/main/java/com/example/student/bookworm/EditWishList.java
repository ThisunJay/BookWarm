package com.example.student.bookworm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import Database.DBHandler;
import Model.WishList;

public class EditWishList extends AppCompatActivity {

    EditText title,author,price;
    DBHandler db;
    String Title,Author;
    double Price;
    Button save;
    WishList wishList;

    @Override
    protected void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.wish_list_edit);

        title = findViewById(R.id.edt1);
        author = findViewById(R.id.editText2);
        price = findViewById(R.id.editText3);

        db = new DBHandler(this);

        //Intent intent = getIntent();
        //wishList = (WishList) intent.getSerializableExtra("Wishlist");

        //title.setText(wishList.getTitle());
        //author.setText(wishList.getAuthor());
        //price.setText(String.valueOf(wishList.getPrice()));
    }

    public void update(){
        Title = title.getText().toString().trim();
        Author = author.getText().toString().trim();
        //Price = price.



    }
}
