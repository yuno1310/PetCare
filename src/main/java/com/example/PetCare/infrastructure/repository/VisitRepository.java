package com.example.PetCare.infrastructure.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.PetCare.domain.entity.VisitDbO;

@Repository
public class VisitRepository {
  @Autowired
  private DSLContext dsl;

  public boolean save(VisitDbO visit) {
    visit.record.attach(dsl.configuration());
    if (visit.record.store() > 0) {
      return true;
    } else {
      return false;
    }
  }

}
