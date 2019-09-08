package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import Adapters.BookAdapter;
import Database.DBHandler;
import Model.BookInfo;
import Model.RBooks;

public class BooksMain extends AppCompatActivity {

    private ArrayList<BookInfo> arrayList;
    DBHandler db;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_main);

       db = new DBHandler(this);

//        arrayList = new ArrayList<BookInfo>();
//        arrayList.add(new BookInfo( 123, "title", "author","price", "pages", "review") );
//        arrayList.add(new BookInfo( 123, "title", "author","price", "pages", "review") );
//        arrayList.add(new BookInfo( 123, "title", "author","price", "pages", "review") );
//        arrayList.add(new BookInfo( 123, "title", "author","price", "pages", "review") );
//        arrayList.add(new BookInfo( 123, "title", "author","price", "pages", "review") );
//        arrayList.add(new BookInfo( 123, "title", "author","price", "pages", "review") );
//        arrayList.add(new BookInfo( 123, "title", "author","price", "pages", "review") );

        arrayList = db.readAllBookinfo();
        rv = findViewById(R.id.recView);
        BookAdapter adapter = new BookAdapter(arrayList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    public void addBook(View view){
        Intent intent = new Intent(BooksMain.this, AddBook.class);
        startActivity(intent);
    }

    public void viewBook(View view){
        Intent intent = new Intent(BooksMain.this, ViewBook.class);
        startActivity(intent);
    }

    public void onBack(View view){
        Intent intent = new Intent(BooksMain.this, MainActivity.class);
        startActivity(intent);
    }

}
