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

    public UserService(IUserdao userdao) {
        this.userdao = userdao;
    }

    public User saveUser(User user){
        userdao.save(user);
        return user;
    }
    public Optional<User> getUserById(Integer id){
        Optional<User> getUser= userdao.findById(id);
        return getUser;
    }

    public void deleteUser(Integer id){
        userdao.deleteById(id);
    }

    public void updateEmail(Integer id, String email){
        User user = getUserById(id).stream().findFirst().orElse(null);
        if (!(user == null)){
            user.setEmail(email);
        }
    }

    public void updateUserName(Integer id, String userName){
        User user = getUserById(id).stream().findFirst().orElse(null);
        if (!(user == null)){
            user.setUsername(userName);
        }
    }

}