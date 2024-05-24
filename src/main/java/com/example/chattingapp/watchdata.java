package com.example.chattingapp;

import java.io.Serializable;

public class watchdata implements Serializable {

     private int watchimage;
     private String watchmodel;
    private int watchdesc;
   private String watchprice;

    public watchdata() {

    }

    public watchdata(int watchimage, String watchmodel, int watchdesc, String watchprice) {
        this.watchimage = watchimage;
        this.watchmodel=watchmodel;
        this.watchdesc=watchdesc;
        this.watchprice=watchprice;
    }

    public int getWatchimage() {
        return watchimage;
    }

    public void setWatchimage(int watchimage) {
        this.watchimage = watchimage;
    }

    public String getWatchmodel() {
        return watchmodel;
    }

    public void setWatchmodel(String watchmodel) {
        this.watchmodel = watchmodel;
    }

    public int getWatchdesc() {
        return watchdesc;
    }

    public void setWatchdesc(int watchdesc) {
        this.watchdesc = watchdesc;
    }

    public String getWatchprice() {
        return watchprice;
    }

    public void setWatchprice(String watchprice) {
        this.watchprice = watchprice;
    }
}
