package com.carona.abc.caronabc.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository UserRepository;

    public List<UserDAO> getUsers() {
        return UserRepository.findAll();
    }

    public UserDAO createUser(UserDAO userDAO) {
        return UserRepository.save(userDAO);
    }
}