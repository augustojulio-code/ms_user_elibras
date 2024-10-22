package com.user.ms_user.core.service;

import java.util.List;

import com.user.ms_user.core.domain.User;
import com.user.ms_user.core.ports.UserRepositoryPort;
import com.user.ms_user.core.ports.UserServicePort;

public class UserService implements UserServicePort {

    private UserRepositoryPort repositoryPort;

    public UserService(UserRepositoryPort repositoryPort) {

        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<User> findAll() {
        return repositoryPort.findAll();
    }

}
