package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.DBHandler;

public class EditRead extends AppCompatActivity {

    DBHandler db;
    EditText txtn,txta,txtf,txtt,txtg;
    String name,author,from,till,genre;
    String ID;
    Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_read);

        db = new DBHandler(this);

        txtn = findViewById(R.id.etn);
        txta = findViewById(R.id.eta);
        txtf = findViewById(R.id.etf);
        txtt = findViewById(R.id.ett);
        txtg = findViewById(R.id.etg);

        Intent intent = getIntent();

        ID = intent.getStringExtra( "id" );
        Log.i("Passed ID: ", ID);
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

        updateBtn = findViewById(R.id.Abtn4);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name  = txtn.getText().toString().trim();
                author = txta.getText().toString().trim();
                from = txtf.getText().toString().trim();
                till = txtt.getText().toString().trim();
                genre = txtg.getText().toString().trim();

                boolean ret = db.editRead(ID, name, author, from, till, genre);

                if(ret == true){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                    Intent in = new Intent(EditRead.this, ReadingActivity.class);
                    startActivity(in);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Update Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

//    public  void editRead(View view){
//        name  = txtn.getText().toString().trim();
//        author = txta.getText().toString().trim();
//        from = txtf.getText().toString().trim();
//        till = txtt.getText().toString().trim();
//        genre = txtg.getText().toString().trim();
//
//
//        if ( name.length() == 0  ) {
//            Toast.makeText( this, "Amount should be filled", Toast.LENGTH_LONG).show();
//
//        }else if (  author.length() == 0 ) {
//            Toast.makeText(getApplicationContext(), "Note Should be filled", Toast.LENGTH_LONG).show();
//        } else if( from.length() == 0) {
//            Toast.makeText(getApplicationContext(), "From Should be filled", Toast.LENGTH_LONG).show();
//        }else if(till.length() == 0){
//            Toast.makeText(getApplicationContext(), "Till Should be filled", Toast.LENGTH_LONG).show();
//        }else if(genre.length() == 0){
//            Toast.makeText(getApplicationContext(), "Genre Should be filled", Toast.LENGTH_LONG).show();
//        }else {
//            db.editRead(ID, name, author, from, till, genre);
//            Toast.makeText(getApplicationContext(), "Data Edited ", Toast.LENGTH_LONG).show();
//        }

   // }
}
