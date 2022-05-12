package com.carona.abc.caronabc.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository UserRepository;

    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public List<UserDAO> getUsers() {
        return UserRepository.findAll();
    }

    public UserDAO createUser(UserDAO userDAO) {
        return UserRepository.save(userDAO);
    }
}