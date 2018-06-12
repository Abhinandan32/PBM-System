package com.app.pbmsystem.service;

import com.app.pbmsystem.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by dawidbranicki on 20.05.2018.
 */
public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    boolean isExist(User user);

    boolean isExist(Long id);

    Optional<User> getUser(long id);

    void deleteUser(long id);

    User findUserByEmail(String email);
}
