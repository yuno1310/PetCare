package com.example.PetCare.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.PetCare.app.usecase.GetServiceOrderUseCase.Orders;
import com.example.PetCare.domain.entity.ServiceOrderDbO;
import com.example.PetCare.generated.tables.Pet;
import com.example.PetCare.generated.tables.Service;
import com.example.PetCare.generated.tables.Serviceorder;
import com.example.PetCare.generated.tables.Visit;

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

  public List<Orders> getPendingList(UUID branchID) {
    var so = Serviceorder.SERVICEORDER;
    var p = Pet.PET;
    var s = Service.SERVICE;
    var v = Visit.VISIT;

    var records = dsl.select(so.ORDERID, p.PETNAME, s.NAME, v.TIMEIN)
        .from(so)
        .join(p).on(so.PETID.eq(p.PETID))
        .join(s).on(so.SERVICEID.eq(s.SERVICEID))
        .join(v).on(so.VISITID.eq(v.VISITID))
        .where(so.STATE.eq("Pending"))
        .and(v.BRANCHID.eq(branchID))
        .fetch();

    if (records != null) {
      List<Orders> listorder = new ArrayList<>();
      for (var record : records) {
        Orders order = new Orders(record.value1(), record.value2(), record.value3(), record.value4());
        listorder.add(order);
      }
      return listorder;
    } else {
      return null;
    }
  }
}
