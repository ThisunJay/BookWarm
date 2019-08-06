package com.example.student.bookworm;

import android.content.Intent;
import android.icu.util.ULocale;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CategorySettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_settings);
    }

    public void goDelete(View view){
        Intent intent1 = new Intent(CategorySettings.this,DeleteCategory.class);
        startActivity(intent1);
    }

    public void goCategoryhome(View view){
        Intent intent1 = new Intent(CategorySettings.this,Categories.class);
        startActivity(intent1);
    }
    public void goUpdate(View view){
        Intent intent1 = new Intent(CategorySettings.this,UpdateCategory.class);
        startActivity(intent1);
    }

}
