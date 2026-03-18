package com.example.PetCare.domain.entity;

import java.time.OffsetDateTime;
import java.util.UUID;

import com.example.PetCare.generated.tables.Visit;
import com.example.PetCare.generated.tables.records.VisitRecord;

public class VisitDbO {
  public VisitRecord record;

  public VisitDbO(UUID bookingID, UUID branchID, UUID customerID, UUID employeeID, OffsetDateTime timeIn) {
    record = Visit.VISIT.newRecord();
    record.setBookingid(bookingID);
    record.setBranchid(branchID);
    record.setCustomerid(customerID);
    record.setEmployeeid(employeeID);
    record.setTimein(timeIn);
  }

  public VisitDbO(UUID branchID, UUID customerID, UUID employeeID, OffsetDateTime timeIn) {
    record = Visit.VISIT.newRecord();
    record.setBranchid(branchID);
    record.setCustomerid(customerID);
    record.setEmployeeid(employeeID);
    record.setTimein(timeIn);
  }

  public VisitDbO(VisitRecord record) {
    this.record = record;
  }
}
