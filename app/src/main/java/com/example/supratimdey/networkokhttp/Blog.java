package com.example.supratimdey.networkokhttp;

/**
 * Created by Supratim Dey on 1/23/2017.
 */


public class Blog{

    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId(){
        return userId;
    }
    public void setUserId(int input){
        this.userId = input;
    }
    public int getId(){
        return id;
    }
    public void setId(int input){
        this.id = input;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String input){
        this.title = input;
    }
    public String getBody(){
        return body;
    }
    public void setBody(String input){
        this.body = input;
    }
}