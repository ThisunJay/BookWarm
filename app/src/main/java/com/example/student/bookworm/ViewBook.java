package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ViewBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book);
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
