package com.user.ms_user.core.ports;

import java.util.List;

import com.user.ms_user.core.domain.Client;

public interface ClientServicePort {

    Client saveClient(Client client);

    List<Client> findAll();
}
