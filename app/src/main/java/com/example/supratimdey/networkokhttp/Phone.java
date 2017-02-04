package com.example.supratimdey.networkokhttp;

/**
 * Created by Supratim Dey on 2/4/2017.
 */


public class Phone{
    private String mobile;
    private String home;
    private String office;

    public String getMobile(){
        return mobile;
    }
    public void setMobile(String input){
        this.mobile = input;
    }
    public String getHome(){
        return home;
    }
    public void setHome(String input){
        this.home = input;
    }
    public String getOffice(){
        return office;
    }
    public void setOffice(String input){
        this.office = input;
    }
}