package com.user.ms_user.adapters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.ms_user.adapters.entities.ClientEntity;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {

}
