package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashboardModernCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_modern_category);
    }

    public void goToAdd(View v){
        Intent myItent = new Intent(this,OsaAddCategory.class);
        startActivity(myItent);
    }
    public void goBack(View v){
        Intent myItent = new Intent(this,MainActivity.class);
        startActivity(myItent);
    }
}
