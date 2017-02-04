package com.example.supratimdey.networkokhttp;

import java.util.List;

import com.example.supratimdey.networkokhttp.Contact;

/**
 * Created by Supratim Dey on 2/4/2017.
 */



public class ContactList{
    private List<Contact> contacts;

    public List<Contact> getContacts(){
        return contacts;
    }
    public void setContacts(List<Contact> input){
        this.contacts = input;
    }
}