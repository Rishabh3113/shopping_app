package com.example.chattingapp;

import java.io.Serializable;

public class onboardmodel implements Serializable {
    private int onboardimage;
    private String onboardtext;

    public onboardmodel() {
    }


    public onboardmodel(int onboardimage, String onboardtext) {
        this.onboardimage = onboardimage;
        this.onboardtext=onboardtext;



    }

    public int getOnboardimage() {
        return onboardimage;
    }

    public void setOnboardimage(int onboardimage) {
        this.onboardimage = onboardimage;
    }

    public String getOnboardtext() {
        return onboardtext;
    }

    public void setOnboardtext(String onboardtext) {
        this.onboardtext = onboardtext;
    }
}
