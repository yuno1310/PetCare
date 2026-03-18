package com.example.PetCare.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetCare.app.usecase.CreateVisitManuallyUseCase;
import com.example.PetCare.app.usecase.CreateVisitUseCase;
import com.example.PetCare.app.usecase.CreateVisitManuallyUseCase.CreateVisitManuallyRequest;
import com.example.PetCare.app.usecase.CreateVisitManuallyUseCase.CreateVisitManuallyResponse;
import com.example.PetCare.app.usecase.CreateVisitUseCase.CreateVisitRequest;
import com.example.PetCare.app.usecase.CreateVisitUseCase.CreateVisitResponse;

@RestController
@RequestMapping("api/visit")
public class VisitController {
  @Autowired
  private CreateVisitUseCase createVisitUseCase;

  @Autowired
  private CreateVisitManuallyUseCase createVisitManuallyUseCase;

  @PostMapping("/auto-create")
  public ResponseEntity<CreateVisitResponse> createVisist(CreateVisitRequest request) {
    var response = createVisitUseCase.execute(request);
    if (response.sucesss() == true) {
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.badRequest().body(response);
    }
  }

  @PostMapping("/create-manually")
  public ResponseEntity<CreateVisitManuallyResponse> createVisitManually(CreateVisitManuallyRequest request) {
    var response = createVisitManuallyUseCase.execute(request);
    if (response.sucesss() == true) {
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.badRequest().body(response);
    }
  }
}
