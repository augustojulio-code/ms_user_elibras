package com.user.ms_user.core.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientTest {

    private Client client;
    private UUID clientId;
    private String clientName;
    private String clientEmail;

    @BeforeEach
    public void setUp() {
        clientId = UUID.randomUUID();
        clientName = "John Doe";
        clientEmail = "john.doe@example.com";
        client = new Client(clientId, clientName, clientEmail);
    }

    @Test
    public void testGetClientId() {
        assertEquals(clientId, client.getClientId());
    }

    @Test
    public void testSetClientId() {
        UUID newId = UUID.randomUUID();
        client.setClientId(newId);
        assertEquals(newId, client.getClientId());
    }

    @Test
    public void testGetClientName() {
        assertEquals(clientName, client.getClientName());
    }

    @Test
    public void testSetClientName() {
        String newName = "Jane Doe";
        client.setClientName(newName);
        assertEquals(newName, client.getClientName());
    }

    @Test
    public void testGetClientEmail() {
        assertEquals(clientEmail, client.getClientEmail());
    }

    @Test
    public void testSetClientEmail() {
        String newEmail = "jane.doe@example.com";
        client.setClientEmail(newEmail);
        assertEquals(newEmail, client.getClientEmail());
    }
}
