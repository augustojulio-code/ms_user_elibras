package com.user.ms_user.core.ports;

import java.util.List;

import com.user.ms_user.core.domain.User;

public interface UserRepositoryPort {

    List<User> findAll();

}
