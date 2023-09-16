package com.service.ServiceProvider.ServiceEntity;

import com.service.ServiceProvider.ServiceProvider.ServiceProvider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "services")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer serviceId;
    private String serviceName;

    @ManyToMany(mappedBy = "service")
    private List<ServiceProvider> serviceProvider;

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getProfession() {
        return serviceName;
    }

    public void setProfession(String profession) {
        this.serviceName = profession;
    }
}
