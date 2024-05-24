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

public class phoneadapter extends RecyclerView.Adapter<phoneadapter.viewholder3> {

    private Context context;
    private ArrayList<phonedata> phonelist;

    public phoneadapter(ArrayList<phonedata> phonelist,Context context) {
        this.phonelist = phonelist;
        this.context=context;
    }

    @NonNull
    @Override
    public viewholder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.phoneitem,parent,false);
        return new phoneadapter.viewholder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder3 holder, int position) {
        phonedata phonedata=phonelist.get(position);
        holder.phoneimage.setImageResource(phonedata.getPhoneimage());
        holder.phonemodel.setText(phonedata.getPhonemodel());
        holder.phoneprice.setText(phonedata.getPhoneprice());
        holder.phonedesc.setText(phonedata.getPhonedesc());
        setanimation(holder.itemView,position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,phoneclick.class);
                i.putExtra("phoneimage",phonelist.get(holder.getAdapterPosition()).getPhoneimage());
                i.putExtra("phonetitle",phonelist.get(holder.getAdapterPosition()).getPhonemodel());
                i.putExtra("phoneprice",phonelist.get(holder.getAdapterPosition()).getPhoneprice());
                i.putExtra("phonedesc",phonelist.get(holder.getAdapterPosition()).getPhonedesc());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return phonelist.size();
    }

    public static class viewholder3 extends RecyclerView.ViewHolder{

        public ImageView phoneimage;
        public TextView phonemodel;
        public TextView phoneprice;
        public TextView phonedesc;

        public viewholder3(@NonNull View itemView) {
            super(itemView);

            this.phoneimage=itemView.findViewById(R.id.phoneimage);
            this.phonemodel=itemView.findViewById(R.id.phonemodel);
            this.phoneprice=itemView.findViewById(R.id.phoneprice);
            this.phonedesc=itemView.findViewById(R.id.phonedesc);
        }
    }
    private void setanimation(View animateview,int position){
        Animation slide= AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        animateview.startAnimation(slide);
    }
}
