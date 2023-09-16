package com.service.ServiceProvider.Controller;

import com.service.ServiceProvider.Exceptions.ResourceNotFoundException;
import com.service.ServiceProvider.Service.ServiceProviderService;
import com.service.ServiceProvider.ServiceProvider.ServiceProvider;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/serviceprovider")
public class ServiceProviderController {

    @Autowired
    ServiceProviderService serviceProviderService;

    @PostMapping(path = "/register")
    public void CreateServiceProvider(@RequestBody ServiceProvider serviceProvider, HttpServletResponse
            httpServletResponse){
        serviceProviderService.CreateServiceProvider(serviceProvider);
        httpServletResponse.setStatus(200);
    }

    @PostMapping(path = "/delete")
    public void deleteServiceProvider(@RequestBody ServiceProvider serviceProvider, HttpServletResponse response) {
        ServiceProvider newServiceProvider = serviceProviderService.findById(serviceProvider.getId()).orElse(null);
        serviceProviderService.DeleteServiceProvider(newServiceProvider);
            response.setStatus(500);
    }

    @GetMapping(path = "/getall")
    public @ResponseBody List<ServiceProvider> getAllServiceProviders(){
        return serviceProviderService.getAllServiceProviders();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody ServiceProvider findById(@PathVariable Integer id){
        return serviceProviderService.findById(id).orElseThrow(()->new ResourceNotFoundException("Service Provider" +
                "with the given ID not found."));
    }
}
