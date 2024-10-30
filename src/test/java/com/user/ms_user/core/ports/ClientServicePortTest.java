package com.user.ms_user.core.ports;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.user.ms_user.core.domain.Client;

public class ClientServicePortTest {

    @Mock
    private ClientServicePort clientServicePort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveClient() {

        Client client = new Client(UUID.randomUUID(), "João das neves", "nevesjohn@gmail.com");

        when(clientServicePort.saveClient(client)).thenReturn(client);
        Client savedClient = clientServicePort.saveClient(client);
        assertNotNull(savedClient);
        verify(clientServicePort, times(1)).saveClient(client);
    }

    @Test
    void testFindAll() {

        List<Client> clients = Arrays.asList(
                new Client(UUID.randomUUID(), "João das neves", "nevesjohn@gmail.com"),
                new Client(UUID.randomUUID(), "homer simpson", "homer@simpson.com"));

        when(clientServicePort.findAll()).thenReturn(clients);

        List<Client> allClients = clientServicePort.findAll();
        assertEquals(2, allClients.size());
        verify(clientServicePort, times(1)).findAll();
    }

    @Test
    void testFindByIdClient() {

        UUID clientId = UUID.randomUUID();

        Client client = new Client(clientId, "Zé da mina abandonada", "lostcavejoe@gmail.com");

        when(clientServicePort.findByIdClient(clientId)).thenReturn(client);

        Client foundClient = clientServicePort.findByIdClient(clientId);

        assertNotNull(foundClient);
        assertEquals(clientId, foundClient.getClientId());

        verify(clientServicePort, times(1)).findByIdClient(clientId);
    }

    @Test
    void testDeleteById() {

        UUID clientId = UUID.randomUUID();

        doNothing().when(clientServicePort).deleteById(clientId);

        clientServicePort.deleteById(clientId);

        verify(clientServicePort, times(1)).deleteById(clientId);
    }

}
