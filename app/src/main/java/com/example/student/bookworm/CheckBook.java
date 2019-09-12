package com.example.student.bookworm;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CheckBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_book);
    }

    public void onBack(View view){
        Intent intent = new Intent(CheckBook.this, SugAct.class);
        startActivity(intent);
    }

    public void open(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/Maze-Runner-Book-1/dp/0385737955"));
        startActivity(intent);
    }
}
