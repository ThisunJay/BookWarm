package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import Adapters.CategoryAdapter;
import Database.DBHandler;
import Model.Category;

public class DashboardModernCategory extends AppCompatActivity {

    private ArrayList<Category> arrayList;
    DBHandler db;
    RecyclerView rvosa;
    CategoryAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_modern_category);

        db = new DBHandler(this);

        arrayList = db.readAllCategoriesOsa();
        //Log.i("DB" , arrayList.size() + "Size ");
        rvosa = findViewById(R.id.rviewOsa);
        adapter = new CategoryAdapter(arrayList);
        rvosa.setLayoutManager(new LinearLayoutManager(this));
        rvosa.setAdapter(adapter);
    }

    public void goToAdd(View v){
        Intent myItent = new Intent(this,OsaAddCategory.class);
        startActivity(myItent);
    }
    public void goToBooks(View v){
        Intent myItent = new Intent(this,BooksMain.class);
        startActivity(myItent);
    }
    public void goBack(View v){
        Intent myItent = new Intent(this,MainActivity.class);
        startActivity(myItent);
    }
}
