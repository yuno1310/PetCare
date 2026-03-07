package com.example.PetCare.domain.entity;

import java.time.LocalTime;

import com.example.PetCare.generated.tables.Branch;
import com.example.PetCare.generated.tables.records.BranchRecord;

public class BranchDbO {
  public BranchRecord record;

  public BranchDbO(String name, String address, String phoneNumber, LocalTime openTime, LocalTime closeTime) {
    record = Branch.BRANCH.newRecord();
    record.setName(name);
    record.setAddress(address);
    record.setPhone(phoneNumber);
    record.setOpentime(openTime);
    record.setClosetime(closeTime);
  }

  public BranchDbO(BranchRecord record) {
    this.record = record;
  }
}
