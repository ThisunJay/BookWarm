package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Database.DBHandler;

public class OsaAddCategory extends AppCompatActivity {

    DBHandler db;
    EditText osuAddCat;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osa_add_category);

        osuAddCat = findViewById(R.id.osuAddCat);
        db = new DBHandler(this);

    }

    public void addCatBook(View view){
        name = osuAddCat.getText().toString();

        boolean result = db.addCategoryOsu(name);
        osuAddCat.getText().clear();


        if(result == true){
            Toast.makeText(getApplicationContext(),"Success!",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, DashboardModernCategory.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Failed!",Toast.LENGTH_LONG).show();
        }
    }

    public void deleteUser(View view){
        name = osuAddCat.getText().toString();
        boolean result = db.deleteuser( name );

        if(result == true){
            Toast.makeText(getApplicationContext(),"Success!",Toast.LENGTH_LONG).show();
          Intent intent = new Intent(this, DashboardModernCategory.class);
           startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Failed!",Toast.LENGTH_LONG).show();
        }


    }

    public void update( View view){
        name = osuAddCat.getText().toString();
        boolean result = db.userUpdate( name );
        if(result == true){
            Toast.makeText(getApplicationContext(),"Success!",Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(this, DashboardModernCategory.class);
//            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Failed!",Toast.LENGTH_LONG).show();
        }

    }


    public void goBack(View v){
        Intent myItent = new Intent(this,DashboardModernCategory.class);
        startActivity(myItent);
    }
    public void goModify(View v){
        Intent myItent = new Intent(this,DashboardModify.class);
        startActivity(myItent);
    }
}
