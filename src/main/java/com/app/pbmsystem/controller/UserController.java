package com.app.pbmsystem.controller;

import com.app.pbmsystem.model.Offer;
import com.app.pbmsystem.model.User;
import com.app.pbmsystem.service.OfferService;
import com.app.pbmsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dawidbranicki on 14.04.2018.
 */

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user) {
        if (userService.isExist(user)) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        userService.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userService.getUser(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable long id) {
        User user = userService.getUser(id);
        if (user == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
