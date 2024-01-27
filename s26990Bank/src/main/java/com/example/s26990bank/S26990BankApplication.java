package com.example.s26990bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S26990BankApplication {

    public static void main(String[] args) {

        SpringApplication.run(S26990BankApplication.class, args);
        initProcess();
    }
    public static void initProcess(){
        Register.registerNewClient("Adam",242.43f);
        Register.registerNewClient("Bartosz",142.43f);
        Register.getAllClients();
        Transaction.makeTransaction(1,200.43f);
        Transaction.makeTransaction(2,200.00f);
        Transaction.depositMoney(2,400.00f);
        Transaction.makeTransaction(2,200.00f);
        Transaction.showAllTransactions();
        Register.getAllClients();
    }
}
