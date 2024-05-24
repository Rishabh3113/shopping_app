package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class phones extends AppCompatActivity {

    TextView iphone;
    ArrayList<phonedata>phonelist;
    RecyclerView recyclerView4;
    phoneadapter phoneadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phones);
        recyclerView4=findViewById(R.id.recyclephone);
        phonelist=new ArrayList<>();

        phonelist.add(new phonedata(R.drawable.iphone,"iPhone 12 Mini Dubai Made 256 GB"," RS 14999",R.string.iphonemini));
        phonelist.add(new phonedata(R.drawable.images2," iPhone 12 Pro Max Dubai Made 256 GB"," RS 15000",R.string.promax));
        phonelist.add(new phonedata(R.drawable.iphone11," IPhone 11 Dubai Made 256 GB"," RS 15000",R.string.iphone10));
        phonelist.add(new phonedata(R.drawable.iphone11pro," IPhone 11 Pro Dubai Made 256 GB"," RS 15000",R.string.phones));
        phonelist.add(new phonedata(R.drawable.iphone12," iPhone 12 Dubai Made 256 GB"," RS 15000",R.string.phone12));
        phonelist.add(new phonedata(R.drawable.s21ultra," Samsung Galaxy S21 Ultra Dubai made"," RS 19999",R.string.sam));

        phoneadapter=new phoneadapter(phonelist,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView4.setLayoutManager(layoutManager);
        recyclerView4.setAdapter(phoneadapter);
    }
    }
