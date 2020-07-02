package com.multiDataSourceSpring.service;

import com.multiDataSourceSpring.dto.UserDto;
import com.multiDataSourceSpring.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> createUserIfNotFound(int id);

    List<UserDto> getAllUsers();
}
