package com.example.student.bookworm;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashboardModify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_modify);
    }

    public void changeFragment(View view){
        Fragment fragment;
        if (view == findViewById(R.id.btnFragment1)){
            fragment = new AddcategoryFragment();

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fgmntDefault,fragment);
            ft.commit();
        }
        if (view == findViewById(R.id.btnFragment2)){
            fragment = new UpdatecategoryFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fgmntDefault,fragment);
            ft.commit();
        }
        if (view == findViewById(R.id.btnFragment3)){
            fragment = new DeletecategoryFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fgmntDefault,fragment);
            ft.commit();
        }
    }

    public void goBack(View v){
        Intent myItent = new Intent(this,DashboardModernCategory.class);
        startActivity(myItent);
    }
}
