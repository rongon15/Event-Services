package com.service.ServiceProvider.Service;

import com.service.ServiceProvider.ServiceProvider.ServiceProvider;

import java.util.Optional;

public interface IServiceProviderService{

    public void CreateServiceProvider(ServiceProvider serviceProvider);

    public void UpdateServiceProvider(ServiceProvider serviceProvider);

    public void DeleteServiceProvider(ServiceProvider serviceProvider);

    public Optional<ServiceProvider> findById(Integer id);


}
