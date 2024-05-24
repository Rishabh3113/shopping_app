package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class watchclick extends AppCompatActivity {


    ImageView watchimage;
    TextView watchmodel;
    TextView watchprice;
    TextView watchdesc;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watchclick);
        watchimage=findViewById(R.id.clickimage);
        watchmodel=findViewById(R.id.clicktext);
        watchprice=findViewById(R.id.textView4);
        watchdesc=findViewById(R.id.detail);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            watchimage.setImageResource(bundle.getInt("watchimage"));
            watchprice.setText(bundle.getString("watchprice"));
            watchmodel.setText(bundle.getString("watchmodel"));
            watchdesc.setText(bundle.getInt("watchdesc"));

        }
        watchimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://shopyindia.co.in/"));
                startActivity(intent);

            }
        });
    }
}