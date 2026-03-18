package com.example.PetCare.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetCare.app.usecase.CreateServiceOrderUseCase;
import com.example.PetCare.app.usecase.CreateServiceOrderUseCase.CreateServiceOrderRequest;
import com.example.PetCare.app.usecase.CreateServiceOrderUseCase.CreateServiceOrderResponse;

@RestController
@RequestMapping("api/service-order")
public class ServiceOrderController {
  @Autowired
  private CreateServiceOrderUseCase createServiceOrderUseCase;

  @PostMapping
  public ResponseEntity<CreateServiceOrderResponse> createOrder(CreateServiceOrderRequest request) {
    var response = createServiceOrderUseCase.execute(request);
    if (response.success() == true) {
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.badRequest().body(response);
    }
  }
}
