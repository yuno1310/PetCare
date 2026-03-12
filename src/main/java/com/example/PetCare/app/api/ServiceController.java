package com.example.PetCare.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetCare.app.usecase.CreateServiceUseCase;
import com.example.PetCare.app.usecase.CreateServiceUseCase.CreateServiceRequest;
import com.example.PetCare.app.usecase.CreateServiceUseCase.CreateServiceResponse;

@RestController
@RequestMapping("api/service")
public class ServiceController {
  @Autowired
  private CreateServiceUseCase createServiceUseCase;

  @PostMapping
  public ResponseEntity<CreateServiceResponse> createService(CreateServiceRequest request) {
    var response = createServiceUseCase.execute(request);
    if (response.success() == true) {
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.badRequest().body(response);
    }
  }
}
