package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class ReadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
    }

    public void onAdd(View view){
        Intent intent1 = new Intent(ReadingActivity.this,AddReadAct.class);
        startActivity(intent1);
    }
}
