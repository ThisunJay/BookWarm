package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Database.DBHandler;

public class updateReview extends AppCompatActivity {

    TextView txt_title;
    EditText edit_review;
    DBHandler db;
    String review, title, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_review);

        Intent intent = getIntent();

        txt_title = findViewById(R.id.ttv30);
        edit_review = findViewById(R.id.etv30);

        title = intent.getStringExtra("title").trim();
        review = intent.getStringExtra("review").trim();

        txt_title.setText(intent.getStringExtra("title"));
        edit_review.setText(intent.getStringExtra("review"));

        id = intent.getStringExtra("id");
    }

    public void updateButton(View view){

        //title = txt_title.getText().toString();
        review = edit_review.getText().toString().trim();

        //Toast.makeText(getApplicationContext(), review, Toast.LENGTH_LONG).show();

        boolean result = db.bookUpdate("Book 1", "Fuckin bad");
//
        //boolean result = true;
        if(result == true){
            Toast.makeText(getApplicationContext(), "Review Updated", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, BooksMain.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Update failed", Toast.LENGTH_LONG).show();
        }

    }

    public void onBack(View view){
        Intent intent = new Intent(updateReview.this, ViewBook.class);
        startActivity(intent);
    }
}
