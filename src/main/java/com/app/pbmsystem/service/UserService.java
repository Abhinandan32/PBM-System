package com.app.pbmsystem.service;

import com.app.pbmsystem.model.User;
import com.app.pbmsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by dawidbranicki on 14.04.2018.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users.addAll(userRepository.findAll());
        return users;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean isExist(User user) {
        return userRepository.getByFirstNameAndLastName(user.getFirstName(), user.getLastName()) != null;
    }

    public Optional<User> getUser(long id){
        return userRepository.findById(id);
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }
}
