package com.example.PetCare.domain.entity;

import com.example.PetCare.generated.tables.Servicetype;
import com.example.PetCare.generated.tables.records.ServicetypeRecord;

public class ServiceTypeDbO {
  public ServicetypeRecord record;

  public ServiceTypeDbO(String name) {
    record = Servicetype.SERVICETYPE.newRecord();
    record.setName(name);
  }

  public ServiceTypeDbO(ServicetypeRecord record) {
    this.record = record;
  }
}
