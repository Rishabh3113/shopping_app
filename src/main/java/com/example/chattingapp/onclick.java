package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class onclick extends AppCompatActivity {

      TextView onclickprice;
      TextView onclicktitle;
      TextView detail;
      ImageView clickimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onclick);
        onclickprice=findViewById(R.id.textView4);
        onclicktitle=findViewById(R.id.clicktext);
        detail=findViewById(R.id.detail);
        clickimage=findViewById(R.id.clickimage);


        //important

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            detail.setText(bundle.getInt("desc"));//int for description
            clickimage.setImageResource(bundle.getInt("image"));
            onclicktitle.setText(bundle.getString("Title"));
            onclickprice.setText(bundle.getString("price"));
        }

        clickimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://shopyindia.co.in/"));
                startActivity(intent);
            }
        });


    }
}