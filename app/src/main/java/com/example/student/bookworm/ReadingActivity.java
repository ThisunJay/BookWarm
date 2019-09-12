package com.example.student.bookworm;

import android.content.Intent;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
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
    EditText txt_name;
    RAdapter adapter;
    RBooks r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        db = new DBHandler(this);

        arrayList = db.readAllRbooks();
        Log.i("DB" , arrayList.size() + "Size ");
        rv = findViewById(R.id.rviewC);
         adapter = new RAdapter(arrayList,this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(rv);
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

    @Override
    public void OnReadingClick(int position) {
        r = arrayList.get(position);
        Intent intent = new Intent(this,InReadingAct.class);
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
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

             int deleteid = arrayList.get(viewHolder.getAdapterPosition()).getID();
             db.deleteRead(deleteid);
             Toast.makeText(getApplicationContext(),"Deleted!",Toast.LENGTH_LONG).show();


//            arrayList.remove(viewHolder.getAdapterPosition());
//            adapter.notifyDataSetChanged();
        }
    };


}
