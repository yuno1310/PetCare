package com.example.PetCare.domain.entity;

import java.util.UUID;

import com.example.PetCare.generated.tables.Serviceorder;
import com.example.PetCare.generated.tables.records.ServiceorderRecord;

public class ServiceOrderDbO {
  public ServiceorderRecord record;

  public ServiceOrderDbO(UUID visitID, UUID petID, UUID serviceID, String note, String state) {
    record = Serviceorder.SERVICEORDER.newRecord();
    record.setVisitid(visitID);
    record.setPetid(petID);
    record.setServiceid(serviceID);
    record.setNote(note);
    record.setState(state);
  }

  public ServiceOrderDbO(ServiceorderRecord record) {
    this.record = record;
  }
}
