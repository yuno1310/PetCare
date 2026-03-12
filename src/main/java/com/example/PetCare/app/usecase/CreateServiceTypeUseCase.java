package com.example.PetCare.app.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PetCare.domain.entity.ServiceTypeDbO;
import com.example.PetCare.infrastructure.repository.ServiceTypeRepository;

@Service
public class CreateServiceTypeUseCase {
  @Autowired
  private ServiceTypeRepository serviceTypeRepository;

  public CreateServiceTypeResponse execute(CreateServiceTypeRequest request) {
    var serviceType = new ServiceTypeDbO(request.name);
    if (serviceTypeRepository.save(serviceType) == true) {
      return new CreateServiceTypeResponse(true, "Create new service type successfully");
    } else {
      return new CreateServiceTypeResponse(false, "Failed to create new service type");
    }
  }

  public record CreateServiceTypeRequest(String name) {
  }

  public record CreateServiceTypeResponse(boolean success, String message) {
  }
}
