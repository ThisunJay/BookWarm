package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Database.DBHandler;
import Model.BookInfo;

public class ViewBook extends AppCompatActivity {

    TextView txt_title, txt_review;
//    DBHandler db;
//    BookInfo b;
//    ArrayList<BookInfo> arrayList;

    String title, review, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book);

        Intent intent = getIntent();
//
        title = intent.getStringExtra("title");
        review = intent.getStringExtra("review");
        id = intent.getStringExtra("id");
        txt_title = findViewById(R.id.ttv32);
        txt_review = findViewById(R.id.ttv33);
        //arrayList = db.readAllBookinfo();
//
        txt_title.setText(title);
        txt_review.setText(review);
//        for (int c = 0; c < arrayList.size(); c++){
//            b = arrayList.get(c);
//            if(b.getTitle().equals(title)){
//                txt_review.setText(b.getReview());
//            }
//        }
        //String id = intent.getStringExtra("id");

        //String review = intent.getStringExtra("review");
//
        //Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), title, Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), review, Toast.LENGTH_LONG).show();


    }

    public void deleteReview(View view){
        Intent intent = new Intent(ViewBook.this, BooksMain.class);
        startActivity(intent);
    }

    public void updateReview(View view){
        Intent intent = new Intent(ViewBook.this, updateReview.class);
        intent.putExtra("title", title);
        intent.putExtra("review", review);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public void onBack(View view){
        Intent intent = new Intent(ViewBook.this, BooksMain.class);
        startActivity(intent);
    }
}
