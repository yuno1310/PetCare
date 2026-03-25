package com.example.PetCare.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetCare.app.usecase.CreateServiceOrderUseCase;
import com.example.PetCare.app.usecase.GetServiceOrderUseCase;
import com.example.PetCare.app.usecase.CreateServiceOrderUseCase.CreateServiceOrderRequest;
import com.example.PetCare.app.usecase.CreateServiceOrderUseCase.CreateServiceOrderResponse;
import com.example.PetCare.app.usecase.GetServiceOrderUseCase.GetServiceOrderRequest;
import com.example.PetCare.app.usecase.GetServiceOrderUseCase.GetServiceOrderResponse;

@RestController
@RequestMapping("api/service-order")
public class ServiceOrderController {
  @Autowired
  private CreateServiceOrderUseCase createServiceOrderUseCase;

  @Autowired
  private GetServiceOrderUseCase getServiceOrderUseCase;

  @PostMapping
  public ResponseEntity<CreateServiceOrderResponse> createOrder(CreateServiceOrderRequest request) {
    var response = createServiceOrderUseCase.execute(request);
    if (response.success() == true) {
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.badRequest().body(response);
    }
  }

  @GetMapping
  public ResponseEntity<GetServiceOrderResponse> getPendingList(GetServiceOrderRequest request) {
    var response = getServiceOrderUseCase.getPending(request);
    if (response.success() == true) {
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.badRequest().body(response);
    }
  }
}
