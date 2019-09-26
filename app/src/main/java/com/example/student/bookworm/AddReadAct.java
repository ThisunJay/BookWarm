package com.example.student.bookworm;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


import Adapters.RAdapter;
import Database.DBHandler;
import Model.Category;

public class AddReadAct extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    DBHandler adb;
    EditText txtname,txtauth,txtrfrom,txtrtill,txtgenre;
    Spinner spin;
    private String Name;
    private String Author;
    private String RFrom;
    private String RTill;
    ArrayList<String> categoryNames;
    private String label;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_read);

        txtname = findViewById(R.id.ttin7);
        txtauth = findViewById(R.id.ttin8);
        txtrfrom = findViewById(R.id.txtFrom2);
        txtrtill = findViewById(R.id.txtTill);
        //txtgenre = findViewById(R.id.AedG);
        spin = findViewById(R.id.spinner);

        //Spinner populate
        adb = new DBHandler(this);
        categoryNames = new ArrayList<>();
        ArrayList<Category> categories = adb.readAllCategoriesOsa();

        String defaultCat[] = getResources().getStringArray(R.array.cat_cat);
        for (int i = 0; i < defaultCat.length; i++) {
            categoryNames.add(defaultCat[i]);
        }

        for(int x = 0 ;  x < categories.size() ; x++ )
            categoryNames.add(categories.get(x).getUname());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, categoryNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
    }

    public void addRBook(View view){
        //validation
       if(TextUtils.isEmpty(txtname.getText()) || TextUtils.isEmpty(txtauth.getText()) || TextUtils.isEmpty(txtrfrom.getText()) || TextUtils.isEmpty(txtrtill.getText()) ){
           txtname.setError("Enter an Value!");
           txtauth.setError("Enter an value!");
           txtrfrom.setError("Enter an value!");
           txtrtill.setError("Enter an value!");
//           txtgenre.setError("Enter an value!");

           txtname.requestFocus();
           txtauth.requestFocus();
           txtrfrom.requestFocus();
           txtrtill.requestFocus();
//           txtgenre.requestFocus();
        }else{
           //get function
           Name = txtname.getText().toString();
           Author = txtauth.getText().toString();
           RFrom = txtrfrom.getText().toString();
           RTill = txtrtill.getText().toString();
//           Genre = txtgenre.getText().toString();

           //setting result
           boolean result = adb.addReadB(Name,Author,RFrom,RTill,label);

           txtname.getText().clear();
           txtauth.getText().clear();
           txtrfrom.getText().clear();
           txtrtill.getText().clear();
           //txtgenre.getText().clear();

           if(result == true){
               Toast.makeText(getApplicationContext(),"Success!",Toast.LENGTH_LONG).show();
               Intent intent = new Intent(this, ReadingActivity.class);
               startActivity(intent);
           }else{
               Toast.makeText(getApplicationContext(),"Failed!",Toast.LENGTH_LONG).show();
           }
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


    //Date selecting
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


    //spinner function selected
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        String text = adapterView.getItemAtPosition(i).toString();
//        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_LONG).show();
        label = categoryNames.get(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
