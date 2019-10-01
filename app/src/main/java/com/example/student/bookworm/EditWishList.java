package com.example.student.bookworm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import Database.DBHandler;
import Model.WishList;

public class EditWishList extends AppCompatActivity {

    EditText title,author,price;
    TextView heading;
    DBHandler db;
    String Title,Author;
    Double Price;
    Button save,editBtn;
    WishList wishList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wish_list_edit);

        //heading = findViewById(R.id.tv14);
        //title = findViewById(R.id.edt1);
        //author = findViewById(R.id.editText2);
        //price = findViewById(R.id.editText3);
        //price.setInputType(InputType.TYPE_CLASS_NUMBER);

        //db = new DBHandler(this);
        //Intent intent = getIntent();

        //Title = intent.getStringExtra("title");
        //Author = intent.getStringExtra("author");
        //Price = Double.valueOf(intent.getStringExtra("price"));
        //Price = intent.getDoubleExtra(Price);

        //title.setText(Title);
        //author.setText(Author);
        //price.setText(Price.toString());
        //wishList = (WishList) intent.getSerializableExtra("Wishlist");

        //title.setText(wishList.getTitle())
        //author.setText(wishList.getAuthor());
        //price.setText(String.valueOf(wishList.getPrice()));

     //editBtn =findViewById(R.id.editbtn);

//        `

    }

    /*public void Edit(View view) {

        if (TextUtils.isEmpty(title.getText()) || TextUtils.isEmpty(author.getText()) || TextUtils.isEmpty(price.getText())) {
            title.setError("Enter the Title : ");
            author.setError("Enter the author name : ");
            price.setError("Enter price : ");
        } else {
            Title = title.getText().toString().trim();
            Author = author.getText().toString().trim();
            // Price.setText("RS "+(Double.valueOf(getPrice(wishList))));

            boolean result = db.WishUpdate(Title, Author, Price);

            if (result == true) {
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, viewWish.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Not update", Toast.LENGTH_LONG).show();
            }
        }

    }*/




        //Title = title.getText().toString().trim();
        //Author = author.getText().toString().trim();
        //Price = price.



    }

