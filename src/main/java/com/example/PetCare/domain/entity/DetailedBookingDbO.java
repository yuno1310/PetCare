package com.example.PetCare.domain.entity;

import java.util.UUID;

import com.example.PetCare.generated.tables.Detailedbooking;
import com.example.PetCare.generated.tables.records.DetailedbookingRecord;

public class DetailedBookingDbO {
  public DetailedbookingRecord record;

  public DetailedBookingDbO(UUID bookingID, UUID petID, UUID serviceID, String note, String status) {
    record = Detailedbooking.DETAILEDBOOKING.newRecord();
    record.setBookingid(bookingID);
    record.setPetid(petID);
    record.setServiceid(serviceID);
    record.setNote(note);
    record.setStatus(status);
  }

  public DetailedBookingDbO(DetailedbookingRecord record) {
    this.record = record;
  }
}
