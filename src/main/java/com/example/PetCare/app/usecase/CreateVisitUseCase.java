package com.example.PetCare.app.usecase;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PetCare.domain.entity.VisitDbO;
import com.example.PetCare.infrastructure.repository.VisitRepository;

@Service
public class CreateVisitUseCase {
  @Autowired
  private VisitRepository visitRepository;

  public CreateVisitResponse execute(CreateVisitRequest request) {

    var visit = new VisitDbO(request.bookingID, request.branchID, request.customerID, request.employeeID,
        request.timeIn);
    if (visitRepository.save(visit) == true) {
      return new CreateVisitResponse(true, "Create a new visit successfully");
    } else {
      return new CreateVisitResponse(false, "Failed to create new visit");
    }
  }

  public record CreateVisitRequest(UUID bookingID, UUID branchID, UUID customerID, UUID employeeID,
      OffsetDateTime timeIn) {
  }

  public record CreateVisitResponse(boolean sucesss, String message) {
  }
}
