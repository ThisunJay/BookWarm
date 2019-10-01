package com.example.student.bookworm;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import Adapters.RAdapter;
import Database.DBHandler;
import Model.RBooks;

public class ReadingActivity extends AppCompatActivity implements RAdapter.OnReadingListener{
    private ArrayList<RBooks> arrayList;
    DBHandler db;
    RecyclerView rv;
    EditText txt_name,txt_serch;
    RAdapter adapter;
    RBooks r;
    String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        txt_serch = findViewById(R.id.search);
        txt_serch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

        db = new DBHandler(this);

        arrayList = db.readAllRbooks();
        Log.i("DB" , arrayList.size() + "Size ");
        rv = findViewById(R.id.rviewC);
         adapter = new RAdapter(arrayList,this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(rv);
    }

    //search
    public void filter(String text) {
            ArrayList<RBooks> filteredList = new ArrayList<>();

            for(RBooks item : arrayList){
                if(item.getName().toLowerCase().contains(text.toLowerCase())){
                    filteredList.add(item);
                }
            }

        adapter.filterList(filteredList);
    }

    public void onAdd(View view){
        Intent intent1 = new Intent(ReadingActivity.this,AddReadAct.class);
        startActivity(intent1);
    }

    public void onSug(View view){
        Intent intent1 = new Intent(ReadingActivity.this,SugAct.class);
        startActivity(intent1);
    }

    public void onRview(View view){
        Intent intent1 = new Intent(ReadingActivity.this, InReadingAct.class);
        startActivity(intent1);
    }

    public void onBack(View view){
        Intent intent1 = new Intent(ReadingActivity.this,MainActivity.class);
        startActivity(intent1);
    }

    //recycler view swiping
    @Override
    public void OnReadingClick(int position) {
        r = arrayList.get(position);
        Intent intent = new Intent(this,InReadingAct.class);
        intent.putExtra("ID", r.getID()+"");
        ID = String.valueOf(r.getID());
        Log.i("ID in Reading Act: ", ID);
        intent.putExtra("name",r.getName());
        intent.putExtra("author",r.getAuthor());
        intent.putExtra("from",r.getFrom());
        intent.putExtra("till",r.getTill());
        intent.putExtra("genre",r.getGenre());
        startActivity(intent);
    }

    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {

            new AlertDialog.Builder(viewHolder.itemView.getContext())
                    .setMessage("Confirm Delete?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            int deleteid = arrayList.get(viewHolder.getAdapterPosition()).getID();
                            db.deleteRead(deleteid);
                            Toast.makeText(getApplicationContext(),"Deleted!",Toast.LENGTH_LONG).show();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            adapter.notifyItemChanged(viewHolder.getAdapterPosition());
                        }
                    })
                    .create()
                    .show();
//            arrayList.remove(viewHolder.getAdapterPosition());
//            adapter.notifyDataSetChanged();
        }
    };


}
