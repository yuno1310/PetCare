package com.example.PetCare.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetCare.app.usecase.CreatePetUseCase;
import com.example.PetCare.app.usecase.CreatePetUseCase.CreatePetRequest;

@RestController
@RequestMapping("api/pet")
public class PetController {
  @Autowired
  private CreatePetUseCase createPetUseCase;

  @PostMapping
  public ResponseEntity<String> createPet(CreatePetRequest request) {
    var response = createPetUseCase.execute(request);
    if (response.sucesss() == true) {
      return ResponseEntity.ok(response.message());
    } else {
      return ResponseEntity.badRequest().body(response.message());
    }
  }
}
