package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class items extends AppCompatActivity {

    ArrayList<model> listdata;
    adapter adapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        recyclerView=findViewById(R.id.recycle);
        listdata=new ArrayList<>();


        listdata.add(new model(" Rs 1099","APPLE airpods pro (2nd gen) with MAG safe charging case",R.drawable.gen2,R.string.airpods2));
        listdata.add(new model("RS 299","samsung buds pro 2 (2022)",R.drawable.samsung,R.string.samsung));
        listdata.add(new model("Rs 399","APPLE airpods 3rd generaion (free case cover)",R.drawable.gen3,R.string.rd));
        listdata.add(new model("Rs 899"," Airpods 2 with free case cover",R.drawable.air,R.string.cover));
        listdata.add(new model("Rs 1099", "Apple Airpods 2nd Genreation With Free Case Cover",R.drawable.gen,R.string.second));


        adapter=new adapter(listdata, this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}