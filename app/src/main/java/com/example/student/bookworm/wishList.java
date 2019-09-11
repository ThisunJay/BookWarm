package com.example.student.bookworm;

import android.content.Intent;
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

import Adapters.WishAdapter;
import Database.DBHandler;
import Model.WishList;

public class wishList extends AppCompatActivity implements WishAdapter.OnWishingListener{
    private ArrayList<WishList> arrayList;
    DBHandler db;
    RecyclerView rv;
    WishAdapter adapter;
  //  EditText txt_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
//
        db = new DBHandler(this);

        arrayList = db.readAllWishList();

        rv = findViewById(R.id.recycle1);
        rv.setLayoutManager( new LinearLayoutManager(this));

        ArrayList<WishList> arrayList =  db.readAllWishList();
        Log.i("DB" , arrayList.size() + "Size ");
        adapter  = new WishAdapter(arrayList);
        rv.setAdapter(adapter);

        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(rv);
    }

    public void addtowish(View view){
        Intent intent = new Intent(wishList.this, AddToWishlist.class);
        startActivity(intent);
    }

    public void onBack(View view){
        Intent intent = new Intent(wishList.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void OnWishingClick(int position){
        arrayList.get(position);
        Intent intent = new Intent(this,viewWish.class);
        startActivity(intent);
    }
    ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            int deleteID = arrayList.get(viewHolder.getAdapterPosition()).getId();
            db.deleteWish(deleteID);

            arrayList.remove(viewHolder.getAdapterPosition());
            adapter.setArrayList(arrayList);

            Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();

         //  arrayList.remove(viewHolder.getAdapterPosition());
           //adapter.notifyDataSetChanged();
        }
    };
}
