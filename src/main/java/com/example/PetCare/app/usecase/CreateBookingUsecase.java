package com.example.PetCare.app.usecase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PetCare.domain.entity.BookingDbO;
import com.example.PetCare.infrastructure.repository.BookingRepository;

@Service
public class CreateBookingUsecase {
  @Autowired
  private BookingRepository bookingRepository;

  public CreateBookingResponse execute(CreateBookingRequest request) {

    var booking = new BookingDbO(request.branchID, request.employeeID, request.customerID, request.petID, request.note);
    if (bookingRepository.save(booking) == true) {
      return new CreateBookingResponse(true, "Create new booking sucessfully");
    } else {
      return new CreateBookingResponse(false, "Failed to create new booking");
    }
  }

  public record CreateBookingRequest(UUID branchID, UUID employeeID, UUID customerID, UUID petID, String note) {
  }

  public record CreateBookingResponse(boolean sucess, String message) {
  }
}
