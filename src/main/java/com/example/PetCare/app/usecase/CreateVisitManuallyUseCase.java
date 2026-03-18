
package com.example.PetCare.app.usecase;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PetCare.domain.entity.VisitDbO;
import com.example.PetCare.infrastructure.repository.VisitRepository;

@Service
public class CreateVisitManuallyUseCase {
  @Autowired
  private VisitRepository visitRepository;

  public CreateVisitManuallyResponse execute(CreateVisitManuallyRequest request) {
    var visit = new VisitDbO(request.branchID, request.customerID, request.employeeID, request.timeIn);
    if (visitRepository.save(visit) == true) {
      return new CreateVisitManuallyResponse(true, "Create a new visit sucessful manually");
    } else {
      return new CreateVisitManuallyResponse(false, "Failed to create new visit by manually");
    }
  }

  public record CreateVisitManuallyRequest(UUID branchID, UUID customerID, UUID employeeID,
      OffsetDateTime timeIn) {
  }

  public record CreateVisitManuallyResponse(boolean sucesss, String message) {
  }
}
