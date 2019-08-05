package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class onReadingAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_reading);
    }

    public void onBack(View view){
        Intent intent = new Intent(onReadingAct.this, ReadingActivity.class);
        startActivity(intent);
    }
}
