package com.user.ms_user.adapters.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.user.ms_user.core.domain.Client;
import com.user.ms_user.core.ports.ClientServicePort;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientServicePort servicePort;

    @GetMapping("/list-clients")
    public ResponseEntity<List<Client>> findAll() {

        List<Client> list = servicePort.findAll();

        return ResponseEntity.ok().body(list);

    }

    @PostMapping("/create-client")
    public ResponseEntity<Client> createClient(@RequestBody Client objClient) {

        objClient = servicePort.saveClient(objClient);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objClient.getClientId())
                .toUri();

        return ResponseEntity.created(uri).body(objClient);

    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> findById(@PathVariable UUID id) {

        Client client = servicePort.findByIdClient(id);

        return ResponseEntity.ok().body(client);

    }

    @DeleteMapping("/delete-client/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {

        findById(id);

        servicePort.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
