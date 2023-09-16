package com.ecommerce.users.controller;

import com.ecommerce.users.model.*;
import com.ecommerce.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/register")
    public @ResponseBody String addNewUser(@RequestBody User user){
            User newUser = new User();
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setUsername(user.getUsername());
            newUser.setContactNo(user.getContactNo());
            newUser.setUserid(user.getUserid());
            newUser.setPassword(user.getPassword());
            newUser.setEmail(user.getEmail());
            return "Success";
    }

    public @ResponseBody Optional<User> getUser(@RequestParam UUID id) {
        // This returns a JSON or XML with the users
        return userService.getUserById(id);
    }
}