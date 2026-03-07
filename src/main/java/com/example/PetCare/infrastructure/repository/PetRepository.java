package com.example.PetCare.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.PetCare.domain.entity.PetDbO;
import com.example.PetCare.generated.tables.Pet;

@Repository
public class PetRepository {
  @Autowired
  private DSLContext dsl;

  public boolean save(PetDbO pet) {
    pet.record.attach(dsl.configuration());
    if (pet.record.store() > 0) {
      return true;
    } else {
      return false;
    }
  }

  public List<PetDbO> getListPet(UUID customerID) {
    var records = dsl.selectFrom(Pet.PET).where(Pet.PET.CUSTOMERID.eq(customerID)).fetch();
    if (records != null) {
      List<PetDbO> result = new ArrayList<PetDbO>();
      for (var pet : records) {
        result.add(new PetDbO(pet));
      }
      return result;
    } else {
      return null;
    }
  }
}
