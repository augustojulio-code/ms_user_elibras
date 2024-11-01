package com.user.ms_user.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.user.ms_user.core.domain.Client;
import com.user.ms_user.core.ports.ClientRepositoryPort;

public class ClientServiceTest {

    @Mock
    private ClientRepositoryPort repositoryPort;

    @InjectMocks
    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Given
        List<Client> clients = List.of(new Client(), new Client());
        when(repositoryPort.findAll()).thenReturn(clients);

        // When
        List<Client> result = clientService.findAll();

        // Then
        assertEquals(2, result.size());
        verify(repositoryPort, times(1)).findAll();
    }

    @Test
    public void testSaveClient() {
        // Given
        Client client = new Client();
        when(repositoryPort.saveClient(client)).thenReturn(client);

        // When
        Client result = clientService.saveClient(client);

        // Then
        assertEquals(client, result);
        verify(repositoryPort, times(1)).saveClient(client);
    }

    @Test
    public void testFindByIdClient() {
        // Given
        UUID clientId = UUID.randomUUID();
        Client client = new Client();
        when(repositoryPort.findByIdClient(clientId)).thenReturn(client);

        // When
        Client result = clientService.findByIdClient(clientId);

        // Then
        assertEquals(client, result);
        verify(repositoryPort, times(1)).findByIdClient(clientId);
    }

    @Test
    public void testDeleteById() {
        // Given
        UUID clientId = UUID.randomUUID();

        // When
        clientService.deleteById(clientId);

        // Then
        verify(repositoryPort, times(1)).deleteById(clientId);
    }
}
