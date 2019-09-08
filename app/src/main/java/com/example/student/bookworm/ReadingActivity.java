package com.example.student.bookworm;

import android.content.Intent;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;

import Adapters.RAdapter;
import Database.DBHandler;
import Model.RBooks;

public class ReadingActivity extends AppCompatActivity implements RAdapter.OnReadingListener{
    private ArrayList<RBooks> arrayList;
    DBHandler db;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        db = new DBHandler(this);

        arrayList = db.readAllRbooks();
        rv = findViewById(R.id.rviewC);
        RAdapter adapter = new RAdapter(arrayList,this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    public void onAdd(View view){
        Intent intent1 = new Intent(ReadingActivity.this,AddReadAct.class);
        startActivity(intent1);
    }

    public void onSug(View view){
        Intent intent1 = new Intent(ReadingActivity.this,SugAct.class);
        startActivity(intent1);
    }

    public void onRview(View view){
        Intent intent1 = new Intent(ReadingActivity.this, InReadingAct.class);
        startActivity(intent1);
    }

    public void onBack(View view){
        Intent intent1 = new Intent(ReadingActivity.this,MainActivity.class);
        startActivity(intent1);
    }

    @Override
    public void OnReadingClick(int position) {
        arrayList.get(position);
        Intent intent = new Intent(this,InReadingAct.class);
        startActivity(intent);
    }
}
