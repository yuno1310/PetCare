package com.example.PetCare.infrastructure.repository;

import java.util.UUID;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.PetCare.app.usecase.GetBookingUseCase.DetailedBookingDTO;
import com.example.PetCare.domain.entity.DetailedBookingDbO;
import com.example.PetCare.generated.tables.Booking;
import com.example.PetCare.generated.tables.Customer;
import com.example.PetCare.generated.tables.Detailedbooking;
import com.example.PetCare.generated.tables.Pet;
import com.example.PetCare.generated.tables.Service;

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

  public DetailedBookingDTO findBooking(String phoneNumber, UUID branchID) {

    var b = Booking.BOOKING;
    var d = Detailedbooking.DETAILEDBOOKING;
    var c = Customer.CUSTOMER;
    var p = Pet.PET;
    var s = Service.SERVICE;

    var record = dsl
        .select(
            b.BOOKINGID,
            c.NAME,
            p.PETID,
            p.PETNAME,
            s.NAME)
        .from(b)
        .join(c).on(c.CUSTOMERID.eq(b.CUSTOMERID))
        .join(d).on(d.BOOKINGID.eq(b.BOOKINGID))
        .join(p).on(p.PETID.eq(d.PETID))
        .join(s).on(s.SERVICEID.eq(d.SERVICEID))
        .where(c.PHONENUMBER.eq(phoneNumber))
        .and(b.BRANCHID.eq(branchID))
        .fetchOne();
    if (record != null) {
      return new DetailedBookingDTO(record.value1(), record.value2(), record.value3(), record.value4(),
          record.value5());
    } else {
      return null;
    }
  }
}
