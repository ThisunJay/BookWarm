package com.example.student.bookworm;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import Adapters.WishAdapter;
import Database.DBHandler;
import Model.WishList;

public class wishList extends AppCompatActivity implements WishAdapter.OnWishingListener{
    private ArrayList<WishList> WarrayList;
    DBHandler db;
    RecyclerView rv;
    WishAdapter adapter;
    WishList W;
  //  EditText txt_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
//
        db = new DBHandler(this);

        WarrayList = db.readAllWishList();

        rv = findViewById(R.id.recycle1);
        rv.setLayoutManager( new LinearLayoutManager(this));

        ArrayList<WishList> WarrayList =  db.readAllWishList();
        Log.i("DB" , WarrayList.size() + "Size ");
        adapter  = new WishAdapter(WarrayList,this);
        rv = findViewById(R.id.recycle1);
        rv.setLayoutManager(new LinearLayoutManager(this));
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
        W = WarrayList.get(position);
        Intent intent = new Intent(this,viewWish.class);
        intent.putExtra("TITLE",W.getTitle());
       // intent.putExtra("AUTHOR",W.getAuthor());
        intent.putExtra("PRICE",W.getPrice());
        startActivity(intent);
    }


    ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            int deleteID = WarrayList.get(viewHolder.getAdapterPosition()).getId();
            db.deleteWish(deleteID);

            WarrayList.remove(viewHolder.getAdapterPosition());
            adapter.setArrayList(WarrayList);

            Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();

         //  arrayList.remove(viewHolder.getAdapterPosition());
           //adapter.notifyDataSetChanged();
        }
////////////////////////////////////////////////////////////////////////////

    };

    private class OnWishingListener {
    }


}
