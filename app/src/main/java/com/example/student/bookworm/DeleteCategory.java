package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DeleteCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_category);

        Spinner myspinner = (Spinner) findViewById(R.id.spinner11);
        ArrayAdapter<String> myAdapter= new ArrayAdapter<String>(DeleteCategory.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.deleteCat));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);

    }
    public void onBack(View v){
        Intent myHome = new Intent(DeleteCategory.this,CategorySettings.class);
        startActivity(myHome);
    }



}
