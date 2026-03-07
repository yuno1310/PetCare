package com.example.PetCare.infrastructure.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.PetCare.domain.entity.EmployeeDbO;

@Repository
public class EmployeeRepository {
  @Autowired
  private DSLContext dsl;

  public boolean save(EmployeeDbO employee) {
    employee.record.attach(dsl.configuration());
    if (employee.record.store() > 0) {
      return true;
    } else {
      return false;
    }
  }

}
