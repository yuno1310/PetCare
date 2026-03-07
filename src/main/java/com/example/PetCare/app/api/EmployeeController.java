package com.example.PetCare.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetCare.app.usecase.CreateEmployeeUseCase;
import com.example.PetCare.app.usecase.CreateEmployeeUseCase.CreateEmployeeRequest;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
  @Autowired
  private CreateEmployeeUseCase createEmployee;

  @PostMapping
  public ResponseEntity<String> createEmployee(CreateEmployeeRequest request) {
    var response = createEmployee.execute(request);
    if (response.success() == true) {
      return ResponseEntity.ok(response.message());
    } else {
      return ResponseEntity.badRequest().body(response.message());
    }
  }
}
