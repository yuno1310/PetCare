package com.example.PetCare.infrastructure.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.PetCare.domain.entity.CustomerDbO;
import com.example.PetCare.generated.tables.Customer;

@Repository
public class CustomerRepository {
  @Autowired
  private DSLContext dsl;

  public boolean save(CustomerDbO customer) {
    customer.record.attach(dsl.configuration());
    if (customer.record.store() > 0) {
      return true;
    } else
      return false;
  }

  public CustomerDbO findByPhoneNumber(String phoneNumber) {
    var record = dsl.selectFrom(Customer.CUSTOMER).where(Customer.CUSTOMER.PHONENUMBER.eq(phoneNumber)).fetchOne();
    if (record != null) {
      CustomerDbO result = new CustomerDbO(record);
      return result;
    } else {
      return null;
    }
  }
}
