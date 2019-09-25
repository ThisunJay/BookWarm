package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import Database.DBHandler;
import Model.Category;

public class EditRead extends AppCompatActivity {

    DBHandler db;
    EditText txtn,txta,txtf,txtt;
    Spinner txtg;
    String name,author,from,till,genre;
    String ID;
    Button updateBtn;
    ArrayList<String> categoryNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_read);

        db = new DBHandler(this);

        txtn = findViewById(R.id.etn);
        txta = findViewById(R.id.eta);
        txtf = findViewById(R.id.etf);
        txtt = findViewById(R.id.ett);
        txtg = findViewById(R.id.spinner2);

        db = new DBHandler(this);
        categoryNames = new ArrayList<>();
        ArrayList<Category> categories = db.readAllCategoriesOsa();

        String defaultCat[] = getResources().getStringArray(R.array.cat_cat);
        for (int i = 0; i < defaultCat.length; i++) {
            categoryNames.add(defaultCat[i]);
        }

        for(int x = 0 ;  x < categories.size() ; x++ )
            categoryNames.add(categories.get(x).getUname());

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, categoryNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        txtg.setAdapter(adapter);

        Intent intent = getIntent();

        ID = intent.getStringExtra( "id" );
        Log.i("Passed ID: ", ID);
        name = intent.getStringExtra("name");
        author = intent.getStringExtra("author");
        from = intent.getStringExtra("from");
        till = intent.getStringExtra("till");
        //genre = intent.getStringExtra("genre");

        txtn.setText(name);
        txta.setText(author);
        txtf.setText(from);
        txtt.setText(till);
        //txtg.setText(genre);

        updateBtn = findViewById(R.id.Abtn4);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name  = txtn.getText().toString().trim();
                author = txta.getText().toString().trim();
                from = txtf.getText().toString().trim();
                till = txtt.getText().toString().trim();
                genre = adapter.getItem(txtg.getSelectedItemPosition());
                //genre = txtg.getText().toString().trim();

                boolean ret = db.editRead(ID, name, author, from, till, genre);

                if(ret == true){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                    Intent in = new Intent(EditRead.this, ReadingActivity.class);
                    startActivity(in);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Update Failed", Toast.LENGTH_LONG).show();
                }
            }
        });

        int id = SetSpinnerSelection(getResources().getStringArray(R.array.cat_cat),genre);
        txtg.setSelection(id);
    }

    public void editRead(View view){
        Intent inten = new Intent(this,ReadingActivity.class);
        startActivity(inten);
    }

//    public  void editRead(View view){
//        name  = txtn.getText().toString().trim();
//        author = txta.getText().toString().trim();
//        from = txtf.getText().toString().trim();
//        till = txtt.getText().toString().trim();
//        genre = txtg.getText().toString().trim();
//
//
//        if ( name.length() == 0  ) {
//            Toast.makeText( this, "Amount should be filled", Toast.LENGTH_LONG).show();
//
//        }else if (  author.length() == 0 ) {
//            Toast.makeText(getApplicationContext(), "Note Should be filled", Toast.LENGTH_LONG).show();
//        } else if( from.length() == 0) {
//            Toast.makeText(getApplicationContext(), "From Should be filled", Toast.LENGTH_LONG).show();
//        }else if(till.length() == 0){
//            Toast.makeText(getApplicationContext(), "Till Should be filled", Toast.LENGTH_LONG).show();
//        }else if(genre.length() == 0){
//            Toast.makeText(getApplicationContext(), "Genre Should be filled", Toast.LENGTH_LONG).show();
//        }else {
//            db.editRead(ID, name, author, from, till, genre);
//            Toast.makeText(getApplicationContext(), "Data Edited ", Toast.LENGTH_LONG).show();
//        }

   // }

    public int SetSpinnerSelection(String[] array,String text){
        for(int i = 0;i < array.length;i++){
            if(array[i].equals(text)){
                return i;
            }
        }
        return 0;
    }
}
