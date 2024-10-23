package com.user.ms_user.adapters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.ms_user.core.domain.Client;
import com.user.ms_user.core.ports.ClientServicePort;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientServicePort servicePort;

    @PostMapping("/client")
    public Client createClient(@RequestBody Client client) {

        return servicePort.saveClient(client);
    }

    @GetMapping("/all")
    public List<Client> findAll() {

        return servicePort.findAll();
    }

}
