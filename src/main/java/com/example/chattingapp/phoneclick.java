package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class phoneclick extends AppCompatActivity {

    TextView phonemodel;
    TextView phoneprice;
    TextView phonedesc;
    ImageView phoneimage;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phoneclick);
        phoneimage=findViewById(R.id.clickimage);
        phonemodel=findViewById(R.id.clicktext);
        phoneprice=findViewById(R.id.textView4);
        phonedesc=findViewById(R.id.detail);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            phonedesc.setText(bundle.getInt("phonedesc"));//int for description
            phoneimage.setImageResource(bundle.getInt("phoneimage"));
            phonemodel.setText(bundle.getString("phonetitle"));
            phoneprice.setText(bundle.getString("phoneprice"));
        }

        phoneimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://shopyindia.co.in/"));
                startActivity(intent);
            }
        });



    }
}