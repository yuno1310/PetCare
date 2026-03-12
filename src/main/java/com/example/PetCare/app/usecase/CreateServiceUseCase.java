package com.example.PetCare.app.usecase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PetCare.domain.entity.ServiceDbO;
import com.example.PetCare.infrastructure.repository.ServiceRepository;

@Service
public class CreateServiceUseCase {
  @Autowired
  private ServiceRepository serviceRepository;

  public CreateServiceResponse execute(CreateServiceRequest request) {
    var service = new ServiceDbO(request.typeID, request.name, request.price);
    if (serviceRepository.save(service) == true) {
      return new CreateServiceResponse(true, "Create new service successfully");
    } else
      return new CreateServiceResponse(false, "Failed to create new service");
  }

  public record CreateServiceRequest(UUID typeID, String name, Double price) {
  }

  public record CreateServiceResponse(boolean success, String message) {
  }
}
