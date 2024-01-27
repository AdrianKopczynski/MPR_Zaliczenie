package com.example.s26990bank;

import java.util.ArrayList;
import java.util.List;

public class Register {
    public static List<Client> allClients = new ArrayList<>();
    public static int arraySize;
    public Register(List<Client> allClients){
        this.allClients = allClients;
    }

    public static void registerNewClient(String clientName,float noweSaldo){
        arraySize = allClients.size() + 1;
        Client newClient = new Client(arraySize,clientName,noweSaldo);
        allClients.add(newClient);
    }
    public static void getAllClients(){
        for(Client currentClient : allClients){
            System.out.println("Klient: "+ currentClient.name +" ID: "+ currentClient.ID + " Saldo: "+ currentClient.saldo);
        }
    }
    public static Client currentClient;
    public static void getSpecyficClient(int clientID){
        currentClient = null;
        for(Client currentClient : allClients){
            if(currentClient.ID == clientID){
                System.out.println("Klient: "+ currentClient.name +" ID: "+ currentClient.ID + " Saldo: "+ currentClient.saldo);
            }
        }
        if(currentClient == null){
            System.out.println("Brak klienta o podanym ID!");
        }
    }
    public static List<Client> getClientList(){
        return allClients;
    }
}
