package com.example.PetCare.domain.entity;

import java.time.OffsetDateTime;

import com.example.PetCare.generated.tables.Customer;
import com.example.PetCare.generated.tables.records.CustomerRecord;

public class CustomerDbO {
  public CustomerRecord record;

  public CustomerDbO(String name, String phoneNumber, String email, String citizenID,
      String gender, OffsetDateTime dateOfBirth, Integer LoyaltyPoints, String MembershipTier) {
    record = Customer.CUSTOMER.newRecord();
    record.setName(name);
    record.setPhonenumber(phoneNumber);
    record.setEmail(email);
    record.setCitizenid(citizenID);
    record.setGender(gender);
    record.setDateofbirth(dateOfBirth);
    record.setLoyaltypoints(LoyaltyPoints);
    record.setMembershiptier(MembershipTier);
  }

  public CustomerDbO(CustomerRecord record) {
    this.record = record;
  }
}
