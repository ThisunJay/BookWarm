package com.example.student.bookworm;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


import Database.DBHandler;

public class AddReadAct extends AppCompatActivity {
    DBHandler adb;
    EditText txtname,txtauth,txtrfrom,txtrtill,txtgenre;
    private String Name;
    private String Author;
    private String RFrom;
    private String RTill;
    private String Genre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_read);

        txtname = findViewById(R.id.ttin7);
        txtauth = findViewById(R.id.ttin8);
        txtrfrom = findViewById(R.id.txtFrom2);
        txtrtill = findViewById(R.id.txtTill);
        txtgenre = findViewById(R.id.AedG);

        adb = new DBHandler(this);

    }

    public void addRBook(View view){
        Name = txtname.getText().toString();
        Author = txtauth.getText().toString();
        RFrom = txtrfrom.getText().toString();
        RTill = txtrtill.getText().toString();
        Genre = txtgenre.getText().toString();

        boolean result = adb.addReadB(Name,Author,RFrom,RTill,Genre);

        if(result == true){
            Toast.makeText(getApplicationContext(),"Success!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Failed!",Toast.LENGTH_LONG).show();
        }
    }

    /*public void AddData(){
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
    }*/


    public void updateDate(final View view){


                Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

                DatePickerDialog dialog = new DatePickerDialog( view.getContext() , new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        try {
                            mMonth++;
                            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(   mYear +"-"+ mMonth +"-"+ mDay);

                            if( view.getId() == R.id.txtFrom2 ) {
                                txtrfrom.setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
                            }else if(view.getId() == R.id.txtTill  ){
                                txtrtill.setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
                            }
                        } catch (ParseException e) {
                            txtrfrom.setText( e+"");
                        }
                    }
                },calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH) );
                dialog.show();


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
