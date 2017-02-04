package com.example.supratimdey.networkokhttp;

/**
 * Created by Supratim Dey on 2/4/2017.
 */
public class Contact{
    private String id;
    private String name;
    private String email;
    private String address;
    private String gender;
    protected Phone phone;

    public String getId(){
        return id;
    }
    public void setId(String input){
        this.id = input;
    }
    public String getName(){
        return name;
    }
    public void setName(String input){
        this.name = input;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String input){
        this.email = input;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String input){
        this.address = input;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String input){
        this.gender = input;
    }
    public Phone getPhone(){
        return phone;
    }
    public void setPhone(Phone input){
        this.phone = input;
    }
}