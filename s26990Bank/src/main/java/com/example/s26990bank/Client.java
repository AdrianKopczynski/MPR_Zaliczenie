package com.example.s26990bank;

public class Client {
    public int ID;
    public String name;
    public float saldo;

    Client(int ID,String name,float saldo){
        this.ID = ID;
        this.name = name;
        this.saldo = saldo;
    }
    public int getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }
    
}
