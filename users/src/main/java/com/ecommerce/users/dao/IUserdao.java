package com.ecommerce.users.dao;

import com.ecommerce.users.model.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository
public interface IUserdao extends CrudRepository<User, Integer> {
}
