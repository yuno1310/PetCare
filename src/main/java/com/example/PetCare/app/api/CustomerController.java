package com.example.PetCare.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetCare.app.usecase.CreateCustomerUseCase;
import com.example.PetCare.app.usecase.GetCustomerUseCase;
import com.example.PetCare.app.usecase.CreateCustomerUseCase.CreateCusomerRequest;
import com.example.PetCare.app.usecase.CreateCustomerUseCase.CreateCusomerResponse;
import com.example.PetCare.app.usecase.GetCustomerUseCase.GetCustomerRequest;
import com.example.PetCare.app.usecase.GetCustomerUseCase.GetCustomerRespone;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
  @Autowired
  private CreateCustomerUseCase createCustomerUseCase;

  @Autowired
  private GetCustomerUseCase getCustomerUseCase;

  @PostMapping
  public ResponseEntity<CreateCusomerResponse> createCustomer(CreateCusomerRequest request) {
    var response = createCustomerUseCase.execute(request);

    if (response.success()) {
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.badRequest().body(response);
    }
  }

  @GetMapping
  public ResponseEntity<GetCustomerRespone> customerCheck(GetCustomerRequest request) {
    var response = getCustomerUseCase.getCustomer(request);
    if (response != null) {
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
