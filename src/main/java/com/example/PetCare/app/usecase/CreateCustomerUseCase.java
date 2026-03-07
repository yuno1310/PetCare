package com.example.PetCare.app.usecase;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PetCare.domain.entity.CustomerDbO;
import com.example.PetCare.infrastructure.repository.CustomerRepository;

@Service
public class CreateCustomerUseCase {
  @Autowired
  private CustomerRepository customerRepository;

  public CreateCusomerResponse execute(CreateCusomerRequest request) {
    var customer = new CustomerDbO(request.name, request.phoneNumber, request.email, request.citizenID, request.gender,
        request.dateOfBirth, request.loyaltyPoints, request.membershipTier);

    if (customerRepository.save(customer) == true) {
      return new CreateCusomerResponse(true, "Create customer Successfully");
    } else {
      return new CreateCusomerResponse(false, "Failed to create new customer");
    }
  }

  public record CreateCusomerRequest(String name, String phoneNumber, String email, String citizenID,
      String gender, OffsetDateTime dateOfBirth, Integer loyaltyPoints, String membershipTier) {

  }

  public record CreateCusomerResponse(boolean success, String message) {

  }
}
