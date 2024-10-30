package com.user.ms_user.core.ports;

import java.util.*;

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

public class ClientRepositoryPortTest {

    @Mock
    private ClientRepositoryPort clientRepositoryPort;

    @BeforeEach
    void setup() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveClient() {

        Client client = new Client();

        when(clientRepositoryPort.saveClient(client))
                .thenReturn(client);

        Client savedClient = clientRepositoryPort.saveClient(client);
        assertNotNull(savedClient);
        verify(clientRepositoryPort, times(1)).saveClient(client);

    }

    @Test
    void testFindAll() {

        List<Client> clients = new ArrayList<>();

        when(clientRepositoryPort.findAll()).thenReturn(clients);

        List<Client> result = clientRepositoryPort.findAll();

        assertNotNull(result);
        verify(clientRepositoryPort, times(1)).findAll();
    }

    @Test
    void testFindByIdClient() {

        UUID clientId = UUID.randomUUID();

        Client client = new Client();

        when(clientRepositoryPort.findByIdClient(clientId)).thenReturn(client);

        Client result = clientRepositoryPort.findByIdClient(clientId);

        assertNotNull(result);

        verify(clientRepositoryPort, times(1)).findByIdClient(clientId);

    }

    @Test
    void testDeleteById() {

        UUID clientId = UUID.randomUUID();

        doNothing().when(clientRepositoryPort).deleteById(clientId);

        clientRepositoryPort.deleteById(clientId);

        verify(clientRepositoryPort, times(1)).deleteById(clientId);
    }

}
