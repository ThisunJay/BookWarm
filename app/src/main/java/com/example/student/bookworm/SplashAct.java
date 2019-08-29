package com.example.student.bookworm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashAct extends AppCompatActivity {
    private TextView tvS;
    private ImageView ivS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tvS = (TextView) findViewById(R.id.tvS);
        ivS = (ImageView) findViewById(R.id.ivS);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tvS.startAnimation(myanim);
        ivS.startAnimation(myanim);
        final Intent i = new Intent(this,MainActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(i);
                    finish();


                }
            }
        };
            timer.start();
    }
}
