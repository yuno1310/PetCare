package com.example.PetCare.app.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PetCare.infrastructure.repository.CustomerRepository;
import com.example.PetCare.infrastructure.repository.PetRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetCustomerUseCase {
  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private PetRepository petRepository;

  public GetCustomerRespone getCustomer(GetCustomerRequest request) {
    var customer = customerRepository.findByPhoneNumber(request.phoneNumber);
    if (customer != null) {
      var pets = petRepository.getListPet(customer.record.getCustomerid());
      var listPet = new ArrayList<PetInfo>();
      for (var pet : pets) {
        listPet.add(new PetInfo(pet.record.getPetid().toString(), pet.record.getPetname()));
      }
      return new GetCustomerRespone(customer.record.getCustomerid().toString(), customer.record.getName(),
          customer.record.getPhonenumber(), listPet, true, "Finding customer successfully");
    } else {
      return null;
    }
  }

  public record GetCustomerRequest(String phoneNumber) {
  }

  public record GetCustomerRespone(String customerID, String customerName, String phoneNumber, List<PetInfo> listPet,
      boolean sucess, String message) {
  }

  public record PetInfo(String petID, String petName) {
  }

}
