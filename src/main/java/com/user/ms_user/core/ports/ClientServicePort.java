package com.user.ms_user.core.ports;

import java.util.List;
import java.util.UUID;

import com.user.ms_user.core.domain.Client;

public interface ClientServicePort {

    Client saveClient(Client client);

    List<Client> findAll();

    Client findByIdClient(UUID clientId);

    void deleteById(UUID clientId);
}
