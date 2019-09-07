package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Database.DBHandler;

public class AddToWishlist extends AppCompatActivity {

    DBHandler db;
    EditText title,author,price;
    TextView data;
    private String Title,Athor;
    double Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_wishlist);

        title = findViewById(R.id.editText9);
        author = findViewById(R.id.editText10);
        price = findViewById(R.id.editText12);

        db = new DBHandler(this);

    }

    public void viewWishList(View view){
        Intent intent = new Intent(AddToWishlist.this, wishList.class);
        startActivity(intent);
    }

    public void onBack(View view){
        Intent intent = new Intent(AddToWishlist.this, wishList.class);
        startActivity(intent);
    }

    public void AddWishList(View view){
        Title  = title.getText().toString();
        Athor = author.getText().toString();
        Price =  Double.parseDouble( price.getText().toString() );


        boolean result = db.AddWishList(Title,Athor,Price);


        if(result == true){
            Toast.makeText(getApplicationContext(),"Added to Wish List", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Adding Failed ",Toast.LENGTH_LONG).show();
        }


    }
}
