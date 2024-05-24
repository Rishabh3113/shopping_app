package com.example.chattingapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class watches extends AppCompatActivity {
    TextView watched;

    ArrayList<watchdata> watchlist;

    watchadapter watchadapter;

    RecyclerView recyclerView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watches);
        watched=findViewById(R.id.textView6);
        recyclerView3=findViewById(R.id.recyclewatch);
        watchlist=new ArrayList<>();

         watchlist.add(new watchdata(R.drawable.m8ultra,"I Watch Series MT8 Ultra Original Quality",R.string.m8,"RS 1499"));
        watchlist.add(new watchdata(R.drawable.k17," K17 Pro Smart Watch APPLE Logo Series 7 For Android & iPhone (Black)",R.string.k17,"RS 1199"));
        watchlist.add(new watchdata(R.drawable.i7pro," i7 Pro Series 7 SmartWatch (45mm) with Wireless Charger Compatible with Android & iOS (Black)",R.string.i7,"RS 1199"));
        watchlist.add(new watchdata(R.drawable.apple7," Apple Watch Series 7 Smart Watch (GPS+GLASS, 44mm)"   ,R.string.apple7,"RS 999"));
        watchlist.add(new watchdata(R.drawable.iwatch," I WatchSeries 7 100 Plus Digital Watch – For Boys & Girls",R.string.series7,"RS 1599"));
        watchlist.add(new watchdata(R.drawable.w26," W26 Plus Pro Smart Watch Series 6 For Android & iPhone Crown Working",R.string.w26,"RS 1599"));
        watchlist.add(new watchdata(R.drawable.tf,"  Smart Watch Waterproof T500",R.string.t500,"RS 1099"));
        watchlist.add(new watchdata(R.drawable.mc72," Series 6 Mc72 Smart Watch 52 Wallpaper",R.string.mc72,"RS 1599"));
        watchlist.add(new watchdata(R.drawable.t500,"  Smart Watch Series 6 T500+ Plus",R.string.tplus,"RS 1899"));
        watchlist.add(new watchdata(R.drawable.w26smart,"  W26 Smart Watch – Series 6",R.string.series6,"RS 1650"));
        watchlist.add(new watchdata(R.drawable.infinite,"  Smartwatch Series 6 Infinity Display W26+Pro",R.string.display,"RS 2599"));
        watchlist.add(new watchdata(R.drawable.smartw26,"   Smart Watch w26+",R.string.smart,"RS 1699"));

        watchadapter=new watchadapter(watchlist,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView3.setLayoutManager(layoutManager);
        recyclerView3.setAdapter(watchadapter);
    }
}