package com.example.PetCare.app.usecase;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PetCare.domain.entity.PetDbO;
import com.example.PetCare.infrastructure.repository.PetRepository;

@Service
public class CreatePetUseCase {
  @Autowired
  private PetRepository petRepository;

  public CreatePetResponse execute(CreatePetRequest request) {
    var pet = new PetDbO(request.customerID, request.petName, request.specices, request.breed, request.dateOfBirth,
        request.gender, request.healthStatus);

    if (petRepository.save(pet) == true) {
      return new CreatePetResponse(true, "Create pet sucesssfully");
    } else {
      return new CreatePetResponse(false, "Failed to create new pet");
    }
  }

  public record CreatePetRequest(UUID customerID, String petName, String specices, String breed,
      OffsetDateTime dateOfBirth, String gender, String healthStatus) {
  }

  public record CreatePetResponse(boolean sucesss, String message) {
  }
}
