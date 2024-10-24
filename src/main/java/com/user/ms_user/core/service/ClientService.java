package com.user.ms_user.core.service;

import java.util.List;
import java.util.UUID;

import com.user.ms_user.core.domain.Client;
import com.user.ms_user.core.ports.ClientRepositoryPort;
import com.user.ms_user.core.ports.ClientServicePort;

public class ClientService implements ClientServicePort {

    private final ClientRepositoryPort repositoryPort;

    public ClientService(ClientRepositoryPort repositoryPort) {

        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<Client> findAll() {
        return repositoryPort.findAll();
    }

    @Override
    public Client saveClient(Client client) {

        return repositoryPort.saveClient(client);
    }

    @Override
    public Client findByIdClient(UUID clientId) {

        return repositoryPort.findByIdClient(clientId);
    }

    @Override
    public void deleteById(UUID clientId) {

        repositoryPort.deleteById(clientId);
    }

}
