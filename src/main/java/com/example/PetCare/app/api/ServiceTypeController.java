package com.example.PetCare.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetCare.app.usecase.CreateServiceTypeUseCase;
import com.example.PetCare.app.usecase.CreateServiceTypeUseCase.CreateServiceTypeRequest;
import com.example.PetCare.app.usecase.CreateServiceTypeUseCase.CreateServiceTypeResponse;

@RestController
@RequestMapping("api/service-type")
public class ServiceTypeController {
  @Autowired
  private CreateServiceTypeUseCase createServiceTypeUseCase;

  @PostMapping
  public ResponseEntity<CreateServiceTypeResponse> createServiceType(CreateServiceTypeRequest request) {
    var response = createServiceTypeUseCase.execute(request);
    if (response.success() == true) {
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.badRequest().body(response);
    }

  }
}
