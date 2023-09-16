package com.ecommerce.users.service;

import com.ecommerce.users.dao.*;
import com.ecommerce.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    IUserdao userdao;

    public void saveUser(User user){
        userdao.save(user);
    }
    public Optional<User> getUserById(UUID id){
        Optional<User> getUser= userdao.findById(id);
        return getUser;
    }


}