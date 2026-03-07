package com.example.PetCare.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetCare.app.usecase.CreateBracnhUseCase;
import com.example.PetCare.app.usecase.CreateBracnhUseCase.CreateBracnhRequest;

@RestController
@RequestMapping("api/branch")
public class BranchController {
  @Autowired
  private CreateBracnhUseCase createBracnhUseCase;

  @PostMapping
  public ResponseEntity<String> createBranch(CreateBracnhRequest request) {
    var response = createBracnhUseCase.execute(request);

    if (response.success() == true) {
      return ResponseEntity.ok(response.message());
    } else {
      return ResponseEntity.badRequest().body(response.message());
    }
  }
}
