package com.example.s26990bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class TransactionTest {
    private Register register;
    private Client client1;
    private Client client2;
    private Transaction transaction1;
    private Transaction transaction2;
    private List<Client> allClients;
    @BeforeEach
    void setup(){
        this.allClients = new ArrayList<>();
        this.register = new Register(allClients);
        Register.registerNewClient("Bartosz",500.00f);
        Register.registerNewClient("Maciej",500.00f);
        client1 = allClients.get(0);
        client2 = allClients.get(1);
    }

    @Test
    void makeTransaction100(){
        Transaction.makeTransaction(2,200.00f);
        assertThat(client1.saldo==300.00f);
    }
    @Test
    void doNotMakeTransaction(){
        Transaction.makeTransaction(2,700.00f);
        assertThat(client2.saldo == 500.00f);

    }
    @Test
    void makeDeposit(){
        Transaction.depositMoney(1,200.00f);
        assertThat(client1.saldo==700.00f);
    }
    @Test
    void makeTransactionWithAllMoney(){
        Transaction.makeTransaction(1,500.00f);
        assertThat(client1.saldo == 0.00f);
    }
}
