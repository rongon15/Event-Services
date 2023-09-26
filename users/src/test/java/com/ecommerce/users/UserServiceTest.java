package com.ecommerce.users;


import com.ecommerce.users.dao.IUserdao;
import com.ecommerce.users.model.User;
import com.ecommerce.users.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {


    @Mock
    IUserdao userdao;

    UserService userService;

    @BeforeEach
    void setUp() {
        this.userService = new UserService(this.userdao);
    }

    @Test
    public void addUserTest(){

        User user = new User();
        user.setUserid(1);
        user.setUsername("alpharomeo");
        user.setEmail("alpha@gmail.com");
        user.setContactNo(987654166);
        user.setFirstName("alpha");
        user.setLastName("Romeo");
        user.setLastName("welcome");

        userService.saveUser(user);

        Mockito.when(userService.saveUser(Mockito.any(User.class))).thenAnswer(i->i.getArguments()[0]);
        Assertions.assertEquals(user,userService.saveUser(user));

    }

    @Test
    public void getUserByIdTest(){
        UserService userService = new UserService(userdao);
        User user = new User();
        user.setUserid(1);
        user.setUsername("alpharomeo");
        user.setEmail("alpha@gmail.com");
        user.setContactNo(987654166);
        user.setFirstName("alpha");
        user.setLastName("Romeo");
        user.setLastName("welcome");

        userService.saveUser(user);

        Mockito.when(userService.getUserById(Mockito.anyInt())).thenReturn(Optional.of(user));
        Optional<User> expected = userService.getUserById(1);
        Assertions.assertEquals(expected,userService.getUserById(1));

    }
}
