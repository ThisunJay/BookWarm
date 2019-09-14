package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class InReadingAct extends AppCompatActivity {

    TextView txt_name,txt_author,txt_from,txt_till,txt_genre;
    String name,author,from,till,genre, ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_reading);

        Intent intent = getIntent();
//
        ID = intent.getStringExtra("ID");
        Log.i("ID in reading act: ", ID);
        name = intent.getStringExtra("name");
        Log.i("Name: ", name);
        author = intent.getStringExtra("author");
        from = intent.getStringExtra("from");
        till = intent.getStringExtra("till");
        genre = intent.getStringExtra("genre");
//
        txt_name = findViewById(R.id.ttv20);
        txt_author = findViewById(R.id.textView10);
        txt_from = findViewById(R.id.ttv24);
        txt_till = findViewById(R.id.ttv25);
        txt_genre = findViewById(R.id.ttv26);
//
        txt_name.setText(name);
        txt_author.setText(author);
        txt_from.setText(from);
        txt_till.setText(till);
        txt_genre.setText(genre);
    }

    public void onBack(View view){
        Intent intent = new Intent(InReadingAct.this, ReadingActivity.class);
        startActivity(intent);
    }

    public void onEditRead(View view){
        Intent intent = new Intent(this,EditRead.class);
        intent.putExtra("id", ID);
        Log.i("ID ID : ", ID);
        intent.putExtra("name",name);
        intent.putExtra("author",author);
        intent.putExtra("from",from);
        intent.putExtra("till",till);
        intent.putExtra("genre",genre);
        startActivity(intent);
    }
}
