package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class updateReview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_review);
    }

    public void updateButton(View view){
        Intent intent = new Intent(updateReview.this, ViewBook.class);
        startActivity(intent);
    }

    public void onBack(View view){
        Intent intent = new Intent(updateReview.this, ViewBook.class);
        startActivity(intent);
    }
}
