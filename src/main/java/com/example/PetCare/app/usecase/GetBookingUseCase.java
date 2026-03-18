package com.example.PetCare.app.usecase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PetCare.infrastructure.repository.DetailedBookingRepository;

@Service
public class GetBookingUseCase {
  @Autowired
  private DetailedBookingRepository detailedBookingRepository;

  public GetBookingResponse execute(GetBookingRequest request) {
    var booking = detailedBookingRepository.findBooking(request.phoneNumber, request.branchID);
    if (booking != null) {
      return new GetBookingResponse(true, "Find Booking successfully", booking);
    } else {
      return null;
    }
  }

  public record GetBookingRequest(String phoneNumber, UUID branchID) {
  }

  public record GetBookingResponse(boolean sucess, String message, DetailedBookingDTO booking) {
  }

  public record DetailedBookingDTO(UUID bookingID, String customerName, UUID petID, String petName,
      String serviceName) {
  }
}
