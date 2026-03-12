package com.example.PetCare.infrastructure.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.PetCare.domain.entity.ServiceDbO;

@Repository
public class ServiceRepository {
  @Autowired
  private DSLContext dsl;

  public boolean save(ServiceDbO service) {
    service.record.attach(dsl.configuration());
    if (service.record.store() > 0) {
      return true;
    } else {
      return false;
    }
  }

}
