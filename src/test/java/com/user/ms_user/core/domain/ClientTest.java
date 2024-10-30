package com.user.ms_user.core.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientTest {

    private Client client;
    private UUID clientId;
    private String clientName;
    private String clientEmail;

    @BeforeEach
    void setUp() {
        clientId = UUID.randomUUID();
        clientName = "Maciota John";
        clientEmail = "john.m@example.com";
        client = new Client(clientId, clientName, clientEmail);
    }

    @Test
    void testGetClientId() {
        assertEquals(clientId, client.getClientId());
    }

    @Test
    void testSetClientId() {
        UUID newId = UUID.randomUUID();
        client.setClientId(newId);
        assertEquals(newId, client.getClientId());
    }

    @Test
    void testGetClientName() {
        assertEquals(clientName, client.getClientName());
    }

    @Test
    void testSetClientName() {
        String newName = "Seu madruga";
        client.setClientName(newName);
        assertEquals(newName, client.getClientName());
    }

    @Test
    void testGetClientEmail() {
        assertEquals(clientEmail, client.getClientEmail());
    }

    @Test
    void testSetClientEmail() {
        String newEmail = "madruguinha@hotmail.com";
        client.setClientEmail(newEmail);
        assertEquals(newEmail, client.getClientEmail());
    }

    @Test
    void testHashCode() {

        Client sameClient = new Client(clientId, clientName, clientEmail);

        assertEquals(client.hashCode(), sameClient.hashCode());

        Client differentClient = new Client(UUID.randomUUID(), "Zé da mina abondonada", "zedamina@gmail.com");

        assertNotEquals(client.hashCode(), differentClient.hashCode());
    }

    @Test
    void testEquals() {
        Client sameClient = new Client(clientId, clientName, clientEmail);

        assertTrue(client.equals(sameClient));

        Client differentClient = new Client(UUID.randomUUID(), "Zé da mina abondonada", "zedamina@gmail.com");

        assertFalse(client.equals(differentClient));
        assertFalse(client.equals(null));
        assertFalse(client.equals(new Object()));
    }
}
