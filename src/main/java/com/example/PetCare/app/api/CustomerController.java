package com.example.PetCare.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetCare.app.usecase.CreateCustomerUseCase;
import com.example.PetCare.app.usecase.CreateCustomerUseCase.CreateCusomerRequest;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
  @Autowired
  private CreateCustomerUseCase createCustomerUseCase;

  @PostMapping
  public ResponseEntity<String> createCustomer(CreateCusomerRequest request) {
    var response = createCustomerUseCase.execute(request);

    if (response.success()) {
      return ResponseEntity.ok(response.message());
    } else {
      return ResponseEntity.badRequest().body(response.message());
    }
  }
}
