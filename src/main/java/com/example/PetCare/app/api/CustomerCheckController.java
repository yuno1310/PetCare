package com.example.PetCare.app.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetCare.infrastructure.repository.CustomerRepository;
import com.example.PetCare.infrastructure.repository.PetRepository;

@RestController
@RequestMapping("api/customer-check")
public class CustomerCheckController {
  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private PetRepository petRepository;

  @GetMapping
  public ResponseEntity<CustomerCheckRespone> customerCheck(String phoneNumber) {
    var customer = customerRepository.findByPhoneNumber(phoneNumber);
    if (customer != null) {
      var pets = petRepository.getListPet(customer.record.getCustomerid());
      var listPet = new ArrayList<PetInfo>();
      for (var pet : pets) {
        listPet.add(new PetInfo(pet.record.getPetid().toString(), pet.record.getPetname()));
      }
      var respone = new CustomerCheckRespone(customer.record.getCustomerid().toString(), customer.record.getName(),
          customer.record.getPhonenumber(), listPet);
      return ResponseEntity.ok(respone);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  record CustomerCheckRespone(String customerID, String customerName, String phoneNumber, List<PetInfo> listPet) {
  }

  record PetInfo(String petID, String petName) {
  }
}
