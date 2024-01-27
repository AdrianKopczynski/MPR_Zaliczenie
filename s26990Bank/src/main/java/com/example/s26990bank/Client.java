package com.example.s26990bank;
import java.util.ArrayList;
import java.util.List;
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
    public float getSaldo(){
        return saldo;
    }
    public void setSaldo(){
        this.saldo = saldo;
    }

}
