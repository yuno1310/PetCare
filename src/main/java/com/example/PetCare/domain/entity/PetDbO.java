package com.example.PetCare.domain.entity;

import java.time.OffsetDateTime;
import java.util.UUID;

import com.example.PetCare.generated.tables.Pet;
import com.example.PetCare.generated.tables.records.PetRecord;

public class PetDbO {
  public PetRecord record;

  public PetDbO(UUID customerID, String petName, String species, String breed, OffsetDateTime dateOfBirth,
      String gender,
      String healthStatus) {
    record = Pet.PET.newRecord();
    record.setCustomerid(customerID);
    record.setPetname(petName);
    record.setSpecies(species);
    record.setBreed(breed);
    record.setDateofbirth(dateOfBirth);
    record.setGender(gender);
    record.setHealthstatus(healthStatus);
  }

  public PetDbO(PetRecord record) {
    this.record = record;
  }
}
