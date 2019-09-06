package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Database.DBHandler;

public class AddCategory extends AppCompatActivity {

    DBHandler db;
    EditText txt_name;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        txt_name = findViewById(R.id.ttin6);
        db = new DBHandler(this);
    }

    public void onBack(View v){
        Intent myHome = new Intent(AddCategory.this,Categories.class);
        startActivity(myHome);
    }

    public void addCategory(View view){
        name = txt_name.getText().toString();

        boolean result = db.addCategory(name);

        if(result == true){
            Toast.makeText(getApplicationContext(), "Category added", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Adding failed", Toast.LENGTH_LONG).show();
        }
    }
}
