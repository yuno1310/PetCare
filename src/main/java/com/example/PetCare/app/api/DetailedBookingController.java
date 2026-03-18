package com.example.PetCare.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PetCare.app.usecase.CreateDetailedBookingUseCase;
import com.example.PetCare.app.usecase.GetBookingUseCase;
import com.example.PetCare.app.usecase.CreateDetailedBookingUseCase.CreateDetailedBookingRequest;
import com.example.PetCare.app.usecase.CreateDetailedBookingUseCase.CreateDetailedBookingResponse;
import com.example.PetCare.app.usecase.GetBookingUseCase.GetBookingRequest;
import com.example.PetCare.app.usecase.GetBookingUseCase.GetBookingResponse;

@RestController
@RequestMapping("api/detailed-booking")
public class DetailedBookingController {
  @Autowired
  private CreateDetailedBookingUseCase createDetailedBookingUseCase;

  @Autowired
  private GetBookingUseCase getBookingUseCase;

  @PostMapping
  public ResponseEntity<CreateDetailedBookingResponse> createDetailedBooking(CreateDetailedBookingRequest request) {
    var response = createDetailedBookingUseCase.execute(request);

    if (response.sucesss() == true) {
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.badRequest().body(response);
    }
  }

  @GetMapping
  public ResponseEntity<GetBookingResponse> findBooking(GetBookingRequest request) {
    var response = getBookingUseCase.execute(request);
    if (response != null) {
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.badRequest().body(response);
    }
  }
}
