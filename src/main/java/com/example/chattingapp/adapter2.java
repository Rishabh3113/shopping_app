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

public class adapter2 extends RecyclerView.Adapter<adapter2.viewholder> {

    private Context context;
    private ArrayList<onboardmodel>onlistdata;

    public adapter2(ArrayList<onboardmodel> onlistdata,Context context) {
        this.onlistdata = onlistdata;
        this.context=context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.onboard,parent,false);
        return new viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        onboardmodel onboardmodel=onlistdata.get(position);
        holder.ontext.setText(onboardmodel.getOnboardtext());
        holder.onimage.setImageResource(onboardmodel.getOnboardimage());

        setanimation(holder.itemView,position);

        if(position==0){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context,phones.class);
                    context.startActivity(intent);
                }
            });
        }
        if(position==1){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(context, items.class);
                    context.startActivity(i);
                }
            });
        }
        if(position==2){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context,watches.class);
                    context.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return onlistdata.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder{
        public ImageView onimage;
        public TextView ontext;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            this.onimage=itemView.findViewById(R.id.mobiles);
            this.ontext=itemView.findViewById(R.id.txt);
        }
    }
    private void setanimation(View animateview,int position){
        Animation slide= AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right);
        animateview.startAnimation(slide);
    }

}
