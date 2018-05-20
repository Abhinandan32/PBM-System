package com.app.pbmsystem.service;

import com.app.pbmsystem.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by dawidbranicki on 20.05.2018.
 */
public interface IUserService {
    List<User> getAllUsers();

    void addUser(User user);

    boolean isExist(User user);

    Optional<User> getUser(long id);

    void deleteUser(long id);

    User findUserByEmail(String email);
}
