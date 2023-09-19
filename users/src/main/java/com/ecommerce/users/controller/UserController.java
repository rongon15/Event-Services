package com.ecommerce.users.controller;

import com.ecommerce.users.ExceptionHandler.NotFoundException;
import com.ecommerce.users.model.*;
import com.ecommerce.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public @ResponseBody Optional<User> getUser(@RequestParam Integer id) {
        // This returns a JSON or XML with the users
        return userService.getUserById(id);
    }

    @DeleteMapping(path = "delete/{id}")
    public HttpStatus deleteUser(@PathVariable("id") Integer id) {
        if (id == null) {
            return HttpStatus.BAD_REQUEST;
        }
        try{
        userService.deleteUser(id);
        return HttpStatus.ACCEPTED;
    }
        catch (Exception e){
            throw new NotFoundException("The user doesn't exist");
        }
    }


    @PostMapping(path = "update_email/{id}")
    public void updateEmail(@PathVariable("id") Integer id, @RequestBody String email) {
        if (!(id == null) && !(email.isEmpty())) {
            userService.updateEmail(id, email);
        }
    }

    public void updateUserName(Integer id, String userName){
        User user = getUser(id).stream().findFirst().orElse(null);
        if (!(user == null)){
            user.setUsername(userName);
        }
    }
}