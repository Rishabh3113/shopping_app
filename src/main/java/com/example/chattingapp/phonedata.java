package com.example.chattingapp;

import java.io.Serializable;

public class phonedata implements Serializable {

    private int phoneimage;
    private String phonemodel;
    private String phoneprice;
    private int phonedesc;

    public phonedata() {
    }

    public phonedata(int phoneimage,String phonemodel,String phoneprice,int phonedesc) {
        this.phoneimage = phoneimage;
        this.phonemodel=phonemodel;
        this.phoneprice=phoneprice;
        this.phonedesc=phonedesc;
    }

    public int getPhoneimage() {
        return phoneimage;
    }

    public void setPhoneimage(int phoneimage) {
        this.phoneimage = phoneimage;
    }

    public String getPhonemodel() {
        return phonemodel;
    }

    public void setPhonemodel(String phonemodel) {
        this.phonemodel = phonemodel;
    }

    public String getPhoneprice() {
        return phoneprice;
    }

    public void setPhoneprice(String phoneprice) {
        this.phoneprice = phoneprice;
    }

    public int getPhonedesc() {
        return phonedesc;
    }

    public void setPhonedesc(int phonedesc) {
        this.phonedesc = phonedesc;
    }
}
