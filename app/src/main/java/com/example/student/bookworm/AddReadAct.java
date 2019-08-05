package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddReadAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_read);
    }

    public void onAddR(View view){
        Intent intent1 = new Intent(AddReadAct.this,ReadingActivity.class);
        startActivity(intent1);
    }

    public void onBack(View view){
        Intent intent1 = new Intent(AddReadAct.this,ReadingActivity.class);
        startActivity(intent1);
    }
}
