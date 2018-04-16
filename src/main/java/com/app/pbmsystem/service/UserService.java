package com.app.pbmsystem.service;

import com.app.pbmsystem.model.User;
import com.app.pbmsystem.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dawidbranicki on 14.04.2018.
 */
@Service
public class UserService {

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users.addAll(projectRepository.findAll());
        return users;
    }

    public void addUser(User user) {
        projectRepository.save(user);
    }

    public boolean isExist(User user) {
        return projectRepository.getByFirstNameAndLastName(user.getFirstName(), user.getLastName()) != null;
    }

    public User getUser(long id){
        return projectRepository.findOneById(id);
    }

    public void deleteUser(long id){
        projectRepository.deleteById(id);
    }
}
