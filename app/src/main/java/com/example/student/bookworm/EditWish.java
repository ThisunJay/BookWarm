package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Database.DBHandler;

public class EditWish extends AppCompatActivity {

    TextView view_title;
    EditText txt_title, txt_author, txt_price;
    String title, author, id;
    Double price;

    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_wish);

        db = new DBHandler(this);

        view_title = findViewById(R.id.w1);
        txt_title = findViewById(R.id.w3);
        txt_author = findViewById(R.id.w5);
        txt_price = findViewById(R.id.w7);

        Intent intent = getIntent();

        title = intent.getStringExtra("title");
        author = intent.getStringExtra("author");
        price = Double.valueOf(intent.getStringExtra("price"));
        id = intent.getStringExtra("id");

        view_title.setText(title);
        txt_title.setText(title);
        txt_author.setText(author);
        txt_price.setText(price.toString());
    }

    public void updateData(View view){
        title = txt_title.getText().toString();
        author = txt_author.getText().toString();
        price = Double.valueOf(txt_price.getText().toString());

        boolean res = db.WishUpdate(id, title, author, price);

        if(res == true){
            Intent inten = new Intent(EditWish.this, wishList.class);
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
            startActivity(inten);
        }else{
            Toast.makeText(getApplicationContext(), "Update Failed", Toast.LENGTH_LONG).show();
        }

    }
}
