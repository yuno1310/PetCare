package com.example.PetCare.app.usecase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PetCare.domain.entity.DetailedBookingDbO;
import com.example.PetCare.infrastructure.repository.DetailedBookingRepository;

@Service
public class CreateDetailedBookingUseCase {
  @Autowired
  private DetailedBookingRepository detailedBookingRepository;

  public CreateDetailedBookingResponse execute(CreateDetailedBookingRequest request) {
    var detailedBooking = new DetailedBookingDbO(request.bookingID, request.petID, request.serviceID, request.note,
        request.status);

    if (detailedBookingRepository.save(detailedBooking) == true) {
      return new CreateDetailedBookingResponse(true, "Create new detailed booking sucesssfully");
    } else {
      return new CreateDetailedBookingResponse(false, "Failed to createn new detailed booking");
    }
  }

  public record CreateDetailedBookingRequest(UUID bookingID, UUID petID, UUID serviceID, String note, String status) {
  }

  public record CreateDetailedBookingResponse(boolean sucesss, String message) {
  }
}
