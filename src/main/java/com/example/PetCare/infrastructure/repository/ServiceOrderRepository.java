package com.example.PetCare.infrastructure.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.PetCare.domain.entity.ServiceOrderDbO;

@Repository
public class ServiceOrderRepository {
  @Autowired
  private DSLContext dsl;

  public boolean save(ServiceOrderDbO order) {
    order.record.attach(dsl.configuration());
    if (order.record.store() > 0) {
      return true;
    } else {
      return false;
    }
  }
}
