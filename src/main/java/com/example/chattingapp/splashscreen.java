package com.example.chattingapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class splashscreen extends AppCompatActivity {
    TextView textView;
    Animation anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView=findViewById(R.id.textView11);
        anim=AnimationUtils.loadAnimation(this,R.anim.anim);
        textView.setAnimation(anim);


      //  YoYo.with(Techniques.RubberBand).duration(2000).repeat(1).playOn(textView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(splashscreen.this,login.class);
                startActivity(intent);
                finish();



            }
        },3000);

    }

};
