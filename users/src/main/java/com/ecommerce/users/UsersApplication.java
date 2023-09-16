package com.ecommerce.users;

import com.ecommerce.users.controller.UserController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan("com.ecommerce.users.dao")
public class UsersApplication {

	public static void main(String[] args) {

		SpringApplication.run(UsersApplication.class, args);
//		SessionFactory factory=  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//
//		System.out.println(factory);
//
//		factory.close();
	}

}
