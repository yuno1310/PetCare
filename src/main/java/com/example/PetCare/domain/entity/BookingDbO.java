package com.example.PetCare.domain.entity;

import java.time.OffsetDateTime;

import com.example.PetCare.generated.tables.Booking;
import java.util.UUID;
import com.example.PetCare.generated.tables.records.BookingRecord;

public class BookingDbO {
  public BookingRecord record;

  public BookingDbO(OffsetDateTime bookingTime, String status, OffsetDateTime createDate, String note) {
    record = Booking.BOOKING.newRecord();
    record.setBookingtime(bookingTime);
    record.setStatus(status);
    record.setNote(note);
  }

  public BookingDbO(UUID branchID, UUID employeeID, UUID customerID, UUID petID, String note) {
    record = Booking.BOOKING.newRecord();
    record.setBranchid(branchID);
    record.setEmployeeid(employeeID);
    record.setCustomerid(customerID);
    record.setPetid(petID);
    record.setNote(note);
  }

  public BookingDbO(BookingRecord record) {
    this.record = record;
  }
}
