package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditRead extends AppCompatActivity {

    EditText txtn,txta,txtf,txtt,txtg;
    String name,author,from,till,genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_read);

        txtn = findViewById(R.id.etn);
        txta = findViewById(R.id.eta);
        txtf = findViewById(R.id.etf);
        txtt = findViewById(R.id.ett);
        txtg = findViewById(R.id.etg);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        author = intent.getStringExtra("author");
        from = intent.getStringExtra("from");
        till = intent.getStringExtra("till");
        genre = intent.getStringExtra("genre");

        txtn.setText(name);
        txta.setText(author);
        txtf.setText(from);
        txtt.setText(till);
        txtg.setText(genre);


    }
}
