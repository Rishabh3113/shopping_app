package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;

public class onboard extends AppCompatActivity {

    ArrayList<onboardmodel> onlistdata;
    adapter2 adapter2;

    RecyclerView recyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);
        recyclerView2=findViewById(R.id.recycle2);
        onlistdata=new ArrayList<>();


        onlistdata.add(new onboardmodel(R.drawable.mobiles,"ANDROID AND IPHONES"));
        onlistdata.add(new onboardmodel(R.drawable.front,"AIRPODS AND CASES"));
        onlistdata.add(new onboardmodel(R.drawable.sm," SMART WATCHES "));


         adapter2=new adapter2(onlistdata,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setAdapter(adapter2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return  true;
    }
}