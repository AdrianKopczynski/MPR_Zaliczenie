package com.example.s26990bank;
import java.util.ArrayList;
import java.util.List;
public class Transaction {
    public Status transactionStatus;
    public int clientIDTransaction;
    public static Client tempClient;

    public static List<Transaction> allTransactions = new ArrayList<>();

    Transaction(Status transactionStatus,int clientID){
        this.transactionStatus = transactionStatus;
        this.clientIDTransaction = clientID;
    }
    public static void makeTransaction(int clientID,float howMuch){
        tempClient = null;
        for(Client currentClient : Register.allClients){
            if(currentClient.ID == clientID){
                tempClient = currentClient;
                if(tempClient.saldo > howMuch){
                    tempClient.saldo -= howMuch;
                    Transaction currentTransaction = new Transaction(Status.ACCEPTED,clientID);
                    allTransactions.add(currentTransaction);
                    System.out.println("Transakcja pomyslna. Kwota "+ howMuch + " zostala pobrana z salda klienta: " + tempClient.name + " Nowe saldo: " + tempClient.saldo);
                }
                else{
                    System.out.println("Blad transakcji! Brak wystarczajacych srodkow! Operacja anulowana!");
                    Transaction currentTransaction = new Transaction(Status.DECLINED,clientID);
                    allTransactions.add(currentTransaction);
                }
            }
        }
        if(tempClient==null) {
            System.out.println("Blad transakcji! Brak klienta o podanym ID! Operacja anulowana!");
        }

    }
    public static void depositMoney(int clientID,float howMuch){
        for(Client currentClient : Register.allClients){
            if(currentClient.ID == clientID){
                tempClient = currentClient;
                tempClient.saldo += howMuch;
                Transaction currentTransaction = new Transaction(Status.ACCEPTED,clientID);
                allTransactions.add(currentTransaction);
                System.out.println("Transakcja pomyslna. Kwota "+ howMuch + " zostala przeslana na saldo klienta: " + tempClient.name + " Nowe saldo: " + tempClient.saldo);
            }
            else{
                System.out.println("Blad transakcji! Brak klienta o podanym ID! Operacja anulowana!");
                Transaction currentTransaction = new Transaction(Status.DECLINED,clientID);
                allTransactions.add(currentTransaction);
            }
        }
    }
    public static void showAllTransactions(){
        for(Transaction currentTransaction: allTransactions){
            System.out.println("Status: "+ currentTransaction.transactionStatus +" ID Klienta: "+ currentTransaction.clientIDTransaction);
        }
    }
}
