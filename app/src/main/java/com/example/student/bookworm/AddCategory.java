package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Database.DBHandler;
import Model.Users;

public class AddCategory extends AppCompatActivity {

    DBHandler db;
    EditText txt_name;
    TextView data;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        txt_name = findViewById(R.id.ttin6);
        data = findViewById(R.id.data);
        db = new DBHandler(this);

        data.setText("");
        int count = 1;

        ArrayList<Users> u = db.readAllInfor();
        for ( Users user : u ) {
            data.append( count  + " " + user.getUname() +"\n"  );
            count++;
        }
    }

    public void onBack(View v){
        Intent myHome = new Intent(AddCategory.this,Categories.class);
        startActivity(myHome);
    }

    public void GoBook(View v){
        Intent myHome = new Intent(AddCategory.this,BooksMain.class);
        startActivity(myHome);
    }

    public void displayInfo(View view){
        data.setText("");
        int count = 1;

        ArrayList<Users> u = db.readAllInfor();
        for ( Users user : u ) {
            data.append( count  + " " + user.getUname() + "\n"  );
            count++;
        }

    }

    public void addCategory(View view){
        name = txt_name.getText().toString();

        boolean result = db.addCategory(name);

        if(result == true){
            Toast.makeText(getApplicationContext(), "Category added", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Adding failed", Toast.LENGTH_LONG).show();
        }
        displayInfo(view);
    }

    public void deleteUser(View view){
        name = txt_name.getText().toString();
        db.deleteuser( name );
        displayInfo(view);


    }

    public void update( View view){
        name = txt_name.getText().toString();
        db.userUpdate( name );
        displayInfo(view);
    }


}
