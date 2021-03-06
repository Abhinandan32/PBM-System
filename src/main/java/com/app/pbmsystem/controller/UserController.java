package com.app.pbmsystem.controller;

import com.app.pbmsystem.model.User;
import com.app.pbmsystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * Created by dawidbranicki on 14.04.2018.
 */

@RestController
@RequestMapping(value = "/user")
@Api(value = "PBM System", description = "All operations for users", tags = "User")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ApiOperation(value = "Get access into service")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Principal user(Principal principal) {
        LOGGER.info("user logged " + principal);
        return principal;
    }

    @ApiOperation(value = "View a list of users", response = ResponseEntity.class)
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @ApiOperation(value = "Add new user")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user) {
        if (userService.isExist(user)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User e-email " +
                    user.getEmail() + " is already in system");
        }
        userService.addUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "Get user using id")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity getUserById(@PathVariable long id) {
        return userService.getUser(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ApiOperation(value = "Delete single user using id")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable long id) {
        if (!userService.isExist(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
