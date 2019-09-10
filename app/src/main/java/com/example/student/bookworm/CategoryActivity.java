package com.example.student.bookworm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import Adapters.CategoryAdapter;
import Database.DBHandler;
import Model.Category;

public class CategoryActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);



        //new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(rvosa);
    }

//    @Override
//    public void OnReadingClick(int position) {
//        arrayList.get(position);
////        Intent intent = new Intent(this,InReadingAct.class);
////        startActivity(intent);
//    }

//    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//        @Override
//        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
//            return false;
//        }

//        @Override
//        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//
//            int deleteid = arrayList.get(viewHolder.getAdapterPosition()).getID();
//            db.deleteRead(deleteid);
//            Toast.makeText(getApplicationContext(),"Deleted!",Toast.LENGTH_LONG).show();
//
//
////            arrayList.remove(viewHolder.getAdapterPosition());
////            adapter.notifyDataSetChanged();
//        }
    //};


}
