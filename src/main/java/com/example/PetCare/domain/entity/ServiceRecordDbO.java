package com.example.PetCare.domain.entity;

import java.util.UUID;

import com.example.PetCare.generated.tables.Servicerecord;
import com.example.PetCare.generated.tables.records.ServicerecordRecord;

public class ServiceRecordDbO {
  public ServicerecordRecord record;

  public ServiceRecordDbO(UUID orderID) {
    record = Servicerecord.SERVICERECORD.newRecord();
    record.setOrderid(orderID);
  }

  public ServiceRecordDbO(ServicerecordRecord record) {
    this.record = record;
  }

}
