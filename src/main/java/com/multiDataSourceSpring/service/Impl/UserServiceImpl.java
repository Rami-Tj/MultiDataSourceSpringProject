package com.multiDataSourceSpring.service.Impl;

import com.github.javafaker.Faker;
import com.multiDataSourceSpring.dto.UserDto;
import com.multiDataSourceSpring.entity.User;
import com.multiDataSourceSpring.repository.UserRepository;
import com.multiDataSourceSpring.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> createUserIfNotFound(int id) {
        User user = null;
        if (!userRepository.findById(id).isPresent()) {
            Faker faker = new Faker(Locale.FRANCE);
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = firstName + "." + lastName + "@gmail.com";
            int age = (int) ((Math.random() * 50) + 25);
            user = userRepository.save(new User(firstName, lastName, email, age, new Random().nextBoolean()));
        }
        return Optional.ofNullable(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> users = userRepository.findAll();
        users.forEach(user -> userDtoList.add(new UserDto(user)));
        return userDtoList;
    }
}
