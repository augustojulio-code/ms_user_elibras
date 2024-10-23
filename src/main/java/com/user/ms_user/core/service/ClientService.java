package com.user.ms_user.core.service;

import java.util.List;

import com.user.ms_user.core.domain.Client;
import com.user.ms_user.core.ports.ClientRepositoryPort;
import com.user.ms_user.core.ports.ClientServicePort;

public class ClientService implements ClientServicePort {

    private ClientRepositoryPort repositoryPort;

    public ClientService(ClientRepositoryPort repositoryPort) {

        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<Client> findAll() {
        return repositoryPort.findAll();
    }

}
