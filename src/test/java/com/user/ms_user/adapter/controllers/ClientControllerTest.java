package com.user.ms_user.adapter.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.user.ms_user.adapters.controllers.ClientController;
import com.user.ms_user.core.domain.Client;
import com.user.ms_user.core.ports.ClientServicePort;
import com.user.ms_user.utils.EnvLoader;

public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ClientServicePort servicePort;

    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    void setUp() {
        EnvLoader.loadEnv();
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    void testFindAll() throws Exception {

        List<Client> clients = List.of(new Client(), new Client());
        when(servicePort.findAll()).thenReturn(clients);

        mockMvc.perform(get("/api/list-clients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(clients.size()));

        verify(servicePort, times(1)).findAll();
    }

    @Test
    void testCreateClient() throws Exception {
        Client client = new Client();
        client.setClientId(UUID.randomUUID());
        when(servicePort.saveClient(any(Client.class))).thenReturn(client);

        mockMvc.perform(post("/api/create-client")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"Zé da mina abondonada\", \"email\": \"joelostcave@hotmail.com\" }"))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", containsString("/api/create-client/" + client.getClientId())));

        verify(servicePort, times(1)).saveClient(any(Client.class));
    }

    @Test
    void testFindById() throws Exception {

        UUID clientId = UUID.randomUUID();
        Client client = new Client();
        client.setClientId(clientId);
        client.setClientName("Zé da mina abondonada");
        client.setClientEmail("joelostcave@hotmail.com");
        when(servicePort.findByIdClient(clientId)).thenReturn(client);

        mockMvc.perform(get("/api/client/{id}", clientId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.clientId").value(client.getClientId().toString()));

        verify(servicePort, times(1)).findByIdClient(clientId);
    }

    @Test
    void testDeleteById() throws Exception {
        UUID clientId = UUID.randomUUID();
        doNothing().when(servicePort).deleteById(clientId);

        mockMvc.perform(delete("/api/delete-client/{id}", clientId))
                .andExpect(status().isNoContent());

        verify(servicePort, times(1)).deleteById(clientId);
    }

}
