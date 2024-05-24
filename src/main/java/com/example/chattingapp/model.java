package com.example.chattingapp;

import java.io.Serializable;

public class model implements Serializable {
    private String model;
    private String price;
     private int image;
     private int desc;



    public model(String price,String model,int image,int desc ) {
        this.price = price;
        this.model=model;
        this.image=image;
        this.desc=desc;

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }
}
