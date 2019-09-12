package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class updateReview extends AppCompatActivity {

    TextView txt_title;
    EditText edit_review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_review);

        Intent intent = getIntent();

        txt_title = findViewById(R.id.ttv30);
        edit_review = findViewById(R.id.etv30);

        txt_title.setText(intent.getStringExtra("title"));
        edit_review.setText(intent.getStringExtra("review"));
    }

    public void updateButton(View view){
        Intent intent = new Intent(updateReview.this, BooksMain.class);
        startActivity(intent);
    }

    public void onBack(View view){
        Intent intent = new Intent(updateReview.this, ViewBook.class);
        startActivity(intent);
    }
}
