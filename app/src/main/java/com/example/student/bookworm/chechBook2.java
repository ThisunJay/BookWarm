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

    public void open(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/Game-Thrones-Song-Fire-Book/dp/0553386794/ref=tmm_pap_swatch_0?_encoding=UTF8&qid=1568188672&sr=1-1"));
        startActivity(intent);
    }

}
