package com.service.ServiceProvider.Dao;

import com.service.ServiceProvider.ServiceProvider.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceProviderDao extends JpaRepository<ServiceProvider,Integer> {
}
