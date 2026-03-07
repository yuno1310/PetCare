package com.example.PetCare.infrastructure.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.PetCare.domain.entity.BookingDbO;

@Repository
public class BookingRepository {
  @Autowired
  private DSLContext dsl;

  public boolean save(BookingDbO booking) {
    booking.record.attach(dsl.configuration());
    if (booking.record.store() > 0) {
      return true;
    } else {
      return false;
    }
  }

}
