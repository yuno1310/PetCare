package com.example.PetCare.domain.entity;

import java.util.UUID;

import com.example.PetCare.generated.tables.Service;
import com.example.PetCare.generated.tables.records.ServiceRecord;

public class ServiceDbO {
  public ServiceRecord record;

  public ServiceDbO(UUID typeID, String name, Double price) {
    record = Service.SERVICE.newRecord();
    record.setTypeid(typeID);
    record.setName(name);
    record.setPrice(price);
  }

  public ServiceDbO(ServiceRecord record) {
    this.record = record;
  }
}
