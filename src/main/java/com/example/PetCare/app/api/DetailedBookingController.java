package com.example.PetCare.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetCare.app.usecase.CreateDetailedBookingUseCase;
import com.example.PetCare.app.usecase.CreateDetailedBookingUseCase.CreateDetailedBookingRequest;
import com.example.PetCare.app.usecase.CreateDetailedBookingUseCase.CreateDetailedBookingResponse;

@RestController
@RequestMapping("api/detailed-booking")
public class DetailedBookingController {
  @Autowired
  CreateDetailedBookingUseCase createDetailedBookingUseCase;

  @PostMapping
  public ResponseEntity<CreateDetailedBookingResponse> createDetailedBooking(CreateDetailedBookingRequest request) {
    var response = createDetailedBookingUseCase.execute(request);

    if (response.sucesss() == true) {
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.badRequest().body(response);
    }
  }

}
