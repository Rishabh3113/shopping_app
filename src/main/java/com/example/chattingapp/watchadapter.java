package com.example.chattingapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class watchadapter extends RecyclerView.Adapter<watchadapter.viewholder2> {

    private Context context;
    private ArrayList<watchdata> watchlist;

    public watchadapter(ArrayList<watchdata> watchlist, Context context) {
        this.watchlist = watchlist;
        this.context=context;
    }

    @NonNull
    @Override
    public viewholder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.watchitem,parent,false);
        return new viewholder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder2 holder, int position) {
        watchdata watchdata=watchlist.get(position);
      holder.watchimage.setImageResource(watchdata.getWatchimage());
        holder.watchmodel.setText(watchdata.getWatchmodel());
        holder.watchprice.setText(watchdata.getWatchprice());
        holder.watchdesc.setText(watchdata.getWatchdesc());
        setanimation(holder.itemView,position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          Intent intent=new Intent(context,watchclick.class);


          intent.putExtra("watchimage",watchlist.get(holder.getAdapterPosition()).getWatchimage());
          intent.putExtra("watchmodel",watchlist.get(holder.getAdapterPosition()).getWatchmodel());
          intent.putExtra("watchprice",watchlist.get(holder.getAdapterPosition()).getWatchprice());
          intent.putExtra("watchdesc",watchlist.get(holder.getAdapterPosition()).getWatchdesc());
          context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return watchlist.size();
    }

    public  static  class  viewholder2 extends RecyclerView.ViewHolder{
        public ImageView watchimage;
        public TextView watchmodel;
        public TextView watchprice;
        public TextView watchdesc;

        public viewholder2(@NonNull View itemView) {
            super(itemView);
            this.watchimage=itemView.findViewById(R.id.watchimage);
            this.watchmodel=itemView.findViewById(R.id.watchmodel);
            this.watchprice=itemView.findViewById(R.id.watchprice);
            this.watchdesc=itemView.findViewById(R.id.wtachdesc);



        }
    }
    private void setanimation(View animateview,int position){
        Animation slide= AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        animateview.startAnimation(slide);
    }
}
