package com.example.PetCare.app.usecase;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PetCare.domain.entity.EmployeeDbO;
import com.example.PetCare.infrastructure.repository.EmployeeRepository;

@Service
public class CreateEmployeeUseCase {
  @Autowired
  private EmployeeRepository employeeRepository;

  public CreateEmployeeResponse execute(CreateEmployeeRequest request) {
    var employee = new EmployeeDbO(request.branchID, request.name, request.dateOfBirth, request.startDate,
        request.gender, request.salary, request.position);

    if (employeeRepository.save(employee) == true) {
      return new CreateEmployeeResponse(true, "Create new employee Successfully");
    } else {
      return new CreateEmployeeResponse(true, "Failed to create new employee");
    }
  }

  public record CreateEmployeeRequest(UUID branchID, String name, OffsetDateTime dateOfBirth, OffsetDateTime startDate,
      String gender, BigDecimal salary, String position) {

  }

  public record CreateEmployeeResponse(boolean success, String message) {

  }
}
