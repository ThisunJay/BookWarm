package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SugAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sug);
    }

    public void onAdd(View view){
        Intent intent1 = new Intent(SugAct.this,CheckBook.class);
        startActivity(intent1);
    }
}
