package com.user.ms_user.adapters.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.ms_user.adapters.entities.ClientEntity;
import com.user.ms_user.core.domain.Client;
import com.user.ms_user.core.ports.ClientRepositoryPort;

@Component
public class ClientRepositoryAdapter implements ClientRepositoryPort {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private ModelMapper modelmapper;

    @Override
    public List<Client> findAll() {

        List<ClientEntity> list = repository.findAll();

        return list.stream()
                .map(clientEntity -> modelmapper.map(clientEntity, Client.class))
                .collect(Collectors.toList());
    }

    @Override
    public Client saveClient(Client client) {

        ClientEntity entity = modelmapper.map(client, ClientEntity.class);

        ClientEntity savedClient = repository.save(entity);

        return modelmapper.map(savedClient, Client.class);
    }

    @Override
    public Client findByIdClient(UUID clientId) {

        Optional<ClientEntity> entity = repository.findById(clientId);

        return modelmapper.map(entity, Client.class);

    }

    @Override
    public void deleteById(UUID clientId) {

        repository.deleteById(clientId);
    }

}
