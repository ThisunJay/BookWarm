package com.example.student.bookworm;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chechBook2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chech_book2);
    }

    public void onBack(View view){
        Intent intent = new Intent(this, SugAct.class);
        startActivity(intent);
    }

}
