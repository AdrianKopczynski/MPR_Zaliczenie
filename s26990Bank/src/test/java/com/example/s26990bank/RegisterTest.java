package com.example.s26990bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class RegisterTest {
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
    }

    @Test
    void doesClientAdded(){
        Register.registerNewClient("Bartosz",200.00f);
        assertFalse(allClients.isEmpty());
    }
    @Test
    void doesClientNotAdded(){
        assertThat(allClients.isEmpty());
    }

}
