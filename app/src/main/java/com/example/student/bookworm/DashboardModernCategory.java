package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import Adapters.CategoryAdapter;
import Database.DBHandler;
import Model.Category;

public class DashboardModernCategory extends AppCompatActivity {

    private ArrayList<Category> arrayList;
    DBHandler db;
    EditText txt_serch;
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

        txt_serch = findViewById(R.id.searchosa);
        txt_serch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });
    }

        public void filter(String text) {
            ArrayList<Category> filteredList = new ArrayList<>();

            for(Category item : arrayList){
                if(item.getUname().toLowerCase().contains(text.toLowerCase())){
                    filteredList.add(item);
                }
            }

            adapter.filterList(filteredList);
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
