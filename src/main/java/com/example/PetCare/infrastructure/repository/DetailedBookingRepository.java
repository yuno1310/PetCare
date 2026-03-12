package com.example.PetCare.infrastructure.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.PetCare.domain.entity.DetailedBookingDbO;

@Repository
public class DetailedBookingRepository {
  @Autowired
  private DSLContext dsl;

  public boolean save(DetailedBookingDbO detailedBooking) {
    detailedBooking.record.attach(dsl.configuration());
    if (detailedBooking.record.store() > 0) {
      return true;
    } else {
    }
    return false;
  }

}
