package com.service.ServiceProvider.Service;

import com.service.ServiceProvider.Dao.IServiceProviderDao;
import com.service.ServiceProvider.ServiceProvider.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProviderService implements IServiceProviderService{

    @Autowired
    private IServiceProviderDao serviceProviderDao;

    @Override
    public void CreateServiceProvider(ServiceProvider serviceProvider) {
        ServiceProvider newServiceProvider = ServiceProvider.builder()
                .firstName(serviceProvider.getFirstName())
                .lastName(serviceProvider.getLastName())
                .email(serviceProvider.getEmail())
                .contactNo(serviceProvider.getContactNo())
                .experience(serviceProvider.getExperience())
                .address(serviceProvider.getAddress())
                .service(serviceProvider.getService())
                .build();
        serviceProviderDao.save(newServiceProvider);

    }

    @Override
    public void UpdateServiceProvider(ServiceProvider serviceProvider) {
        serviceProviderDao.save(serviceProvider);//TODO complete this

    }

    @Override
    public void DeleteServiceProvider(ServiceProvider serviceProvider) {
        serviceProviderDao.delete(serviceProvider);
    }

    @Override
    public Optional<ServiceProvider> findById(Integer id) {
        return serviceProviderDao.findById(id);
    }

    public List<ServiceProvider> getAllServiceProviders(){
         return serviceProviderDao.findAll();
    }
}
