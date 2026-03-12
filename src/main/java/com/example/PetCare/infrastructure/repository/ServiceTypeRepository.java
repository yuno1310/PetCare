package com.example.PetCare.infrastructure.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.PetCare.domain.entity.ServiceTypeDbO;

@Repository
public class ServiceTypeRepository {
  @Autowired
  private DSLContext dsl;

  public boolean save(ServiceTypeDbO serviceType) {
    serviceType.record.attach(dsl.configuration());
    if (serviceType.record.store() > 0) {
      return true;
    } else {
      return false;
    }
  }
}
