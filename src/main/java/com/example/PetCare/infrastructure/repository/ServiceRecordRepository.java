package com.example.PetCare.infrastructure.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.PetCare.domain.entity.ServiceRecordDbO;

@Repository
public class ServiceRecordRepository {
  @Autowired
  private DSLContext dsl;

  public boolean save(ServiceRecordDbO record) {
    record.record.attach(dsl.configuration());
    if (record.record.store() > 0) {
      return true;
    } else {
      return false;
    }
  }
}
