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

public class adapter extends RecyclerView.Adapter<adapter.myviewholder> {
    private Context context;

private ArrayList<model> listdata;

    public adapter(ArrayList<model> listdata, Context context) {
        this.listdata = listdata;
        this.context=context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.each_item,parent,false);
        return new myviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        model models=listdata.get(position);
        holder.itemprice.setText(models.getPrice());
        holder.image.setImageResource(models.getImage());
        holder.iteamname.setText(models.getModel());
        holder.description.setText(models.getDesc());

        setanimation(holder.itemView,position);




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,onclick.class);

                i.putExtra("image",listdata.get(holder.getAdapterPosition()).getImage());
                i.putExtra("Title",listdata.get(holder.getAdapterPosition()).getModel());
                i.putExtra("price",listdata.get(holder.getAdapterPosition()).getPrice());
                i.putExtra("desc",listdata.get(holder.getAdapterPosition()).getDesc());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class myviewholder extends RecyclerView.ViewHolder{

        public ImageView image;
        public TextView iteamname;
        public TextView itemprice;
        public TextView description;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            this.image=itemView.findViewById(R.id.airpodimage);
            this.iteamname=itemView.findViewById(R.id.airpodmodel);
            this.itemprice=itemView.findViewById(R.id.airpodprice);
            this.description=itemView.findViewById(R.id.airpoddesc);

        }
    }
    private void setanimation(View animateview,int position){
        Animation slide= AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        animateview.startAnimation(slide);
    }
}
