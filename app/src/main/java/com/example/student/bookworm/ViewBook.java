package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewBook extends AppCompatActivity {

    //TextView txt_title, txt_review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book);

//        Intent intent = getIntent();
//
//        txt_title = findViewById(R.id.ttv32);
//        txt_review = findViewById(R.id.ttv33);
//
//        int id = Integer.parseInt(intent.getStringExtra("id"));
//        String title = intent.getStringExtra("title");
//        String review = intent.getStringExtra("review");
//
//        txt_title.setText(title);
//        txt_review.setText(review);
    }

    public void deleteReview(View view){
        Intent intent = new Intent(ViewBook.this, BooksMain.class);
        startActivity(intent);
    }

    public void updateReview(View view){
        Intent intent = new Intent(ViewBook.this, updateReview.class);
        startActivity(intent);
    }

    public void onBack(View view){
        Intent intent = new Intent(ViewBook.this, BooksMain.class);
        startActivity(intent);
    }
}
