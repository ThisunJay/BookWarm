package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
    }
    public void goToAddCate(View v){
        Intent myItent = new Intent(Categories.this,AddCategory.class);
        startActivity(myItent);
    }
    public void gotoHome(View v){
        Intent myHome = new Intent(Categories.this,MainActivity.class);
        startActivity(myHome);
    }
    public void gotoSettings(View v){
        Intent mySettings = new Intent(Categories.this,DeleteCategory.class);
        startActivity(mySettings);
    }

}
