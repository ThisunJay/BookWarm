package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Database.DBHandler;

public class AddToWishlist extends AppCompatActivity {

    DBHandler db;
    EditText Title,Author,Price;
    TextView data;
    private String TITLE,AUTHOR;
    double PRICE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_wishlist);

        Title = findViewById(R.id.editText9);
        Author = findViewById(R.id.editText10);
        Price = findViewById(R.id.editText12);
        Price.setInputType(InputType.TYPE_CLASS_NUMBER);

        db = new DBHandler(this);

    }

    public void AddWishList(View view) {
        if (TextUtils.isEmpty(Title.getText()) || TextUtils.isEmpty(Author.getText()) || TextUtils.isEmpty(Price.getText())) {
            Title.setError("Cannot be empty.");
            Author.setError("Cannot be empty.");
            Price.setError("Cannot be empty.");

            Title.requestFocus();
            Author.requestFocus();
            Price.requestFocus();
//            Log.i("DB", Price.getText().toString() );

        } else {
            TITLE = Title.getText().toString();
            AUTHOR = Author.getText().toString();
            PRICE = Double.valueOf(Price.getText().toString());


            boolean result = db.AddWishList(TITLE, AUTHOR, PRICE);

            Title.getText().clear();
            Author.getText().clear();
            Price.getText().clear();

            if (result == true) {
                Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, wishList.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
            }

        }
    }
    public void ViewWishList(View view){
        Intent intent = new Intent(AddToWishlist.this, wishList.class);
        startActivity(intent);
    }

    public void onBack(View view){
        Intent intent = new Intent(AddToWishlist.this, wishList.class);
        startActivity(intent);
    }





}
