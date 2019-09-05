package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddReadAct extends AppCompatActivity {
    DatabaseHelper adidb;
    EditText editName,editAuthor,editFrom,editTill,editGenre;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_read);
        adidb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.ttin7);
        editAuthor = (EditText) findViewById(R.id.ttin8);
        editFrom = (EditText) findViewById(R.id.Aet3);
        editTill = (EditText) findViewById(R.id.Aet6);
        editGenre = (EditText) findViewById(R.id.AedG);
        btnAdd = (Button) findViewById(R.id.Ab1);

        AddData();
    }

    public void AddData(){
        btnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = adidb.insertData(editName.getText().toString(),
                                editAuthor.getText().toString(),
                                editFrom.getText().toString(),
                                editTill.getText().toString(),
                                editGenre.getText().toString()
                        );
                        if(isInserted == true) {
                            Toast.makeText(AddReadAct.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(AddReadAct.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
                        }
                    };
                }
        );
    }

    public void onAddR(View view){
        Intent intent1 = new Intent(AddReadAct.this,ReadingActivity.class);
        startActivity(intent1);
    }

    public void onBack(View view){
        Intent intent1 = new Intent(AddReadAct.this,ReadingActivity.class);
        startActivity(intent1);
    }
}
