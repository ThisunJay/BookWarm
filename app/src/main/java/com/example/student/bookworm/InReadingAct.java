package com.example.student.bookworm;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InReadingAct extends AppCompatActivity {

    TextView txt_name,txt_author,txt_from,txt_till,txt_genre;
    TextView count , countt,hourtv;
    String name,author,from,till,genre, ID;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_reading);

        count = findViewById(R.id.counter);
        countt = findViewById(R.id.textView11);
        hourtv = findViewById(R.id.textView13);

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

       // fdate = till;

        countDownStart();
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

    public void countDownStart(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this,1000);
                try{
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd"
                    );
                    Date futureDate = dateFormat.parse(till);
                    Date currentDate = new Date();
                    if(!currentDate.after(futureDate)){
                        long diff = futureDate.getTime() - currentDate.getTime();
                        long days = diff/(24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        countt.setText("" + String.format("%02d",days));
                        hourtv.setText("" + String.format("%02d",hours));
                    }else{
                        count.setVisibility(View.VISIBLE);
                        count.setText("Days Left!");
                        //textViewGone();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable,1 * 1000);
    }}

//    public void textViewGone(){
//
//    }
//}
