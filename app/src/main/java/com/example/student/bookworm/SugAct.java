package com.example.student.bookworm;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SugAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sug);
    }

    public void onAdd(View view){
        Intent intent1 = new Intent(SugAct.this,CheckBook.class);
        startActivity(intent1);
    }

    public void onBack(View view){
        Intent intent1 = new Intent(SugAct.this,ReadingActivity.class);
        startActivity(intent1);
    }

    public void onMaze(View view){
        Intent intent = new Intent(this,CheckBook.class);
        startActivity(intent);
    }
    public void onGot(View view){
        Intent intent = new Intent(this,chechBook2.class);
        startActivity(intent);
    }

    public void open2(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/City-Girls-Novel-Elizabeth-Gilbert/dp/0593104366/ref=tmm_pap_swatch_0?_encoding=UTF8&qid=&sr="));
        startActivity(intent);
    }

    public void open3(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/Silent-Patient-Alex-Michaelides/dp/1250301696"));
        startActivity(intent);
    }

    public void open4(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/Mrs-Everything-Jennifer-Weiner-ebook/dp/B07P8R6DSK/ref=sr_1_1?crid=11NCBHCVOZFGV&keywords=mrs.everything+by+jennifer+weiner&qid=1569406518&s=digital-text&sprefix=mrs.e%2Cstripbooks-intl-ship%2C448&sr=1-1"));
        startActivity(intent);
    }

    public void open5(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/Night-Tiger-Yangsze-Choo-ebook/dp/B07DNFT938/ref=sr_1_1?crid=3D1QN3HNRLHVD&keywords=the+night+tiger&qid=1569406568&s=digital-text&sprefix=the+night+tig%2Cdigital-text%2C646&sr=1-1"));
        startActivity(intent);
    }

    public void open6(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/Once-More-We-Saw-Stars-ebook/dp/B07DNFBFFK/ref=sr_1_1?crid=2ZD7K6XHXTI96&keywords=once+more+we+saw+stars+by+jayson+greene&qid=1569406722&s=digital-text&sprefix=once+more+%2Cdigital-text%2C743&sr=1-1"));
        startActivity(intent);
    }

    public void open7(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/Daisy-Jones-Taylor-Jenkins-Reid-ebook/dp/B07FK8KZP7/ref=sr_1_1?keywords=daisy+jones&qid=1569406664&s=digital-text&sr=1-1"));
        startActivity(intent);
    }
    }

