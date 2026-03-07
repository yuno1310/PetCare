package com.example.PetCare.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetCare.app.usecase.CreateBookingUsecase;
import com.example.PetCare.app.usecase.CreateBookingUsecase.CreateBookingRequest;

@RestController
@RequestMapping("api/booking")
public class BookingController {
  @Autowired
  private CreateBookingUsecase createBookingUsecase;

  @PostMapping
  public ResponseEntity<String> createBooking(CreateBookingRequest request) {
    var response = createBookingUsecase.execute(request);
    if (response.sucess() == true) {
      return ResponseEntity.ok(response.message());
    } else {
      return ResponseEntity.badRequest().body(response.message());
    }
  }
}
