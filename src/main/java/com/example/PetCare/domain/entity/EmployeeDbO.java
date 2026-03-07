package com.example.PetCare.domain.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import com.example.PetCare.generated.tables.Employee;
import com.example.PetCare.generated.tables.records.EmployeeRecord;

public class EmployeeDbO {
  public EmployeeRecord record;

  public EmployeeDbO(UUID branchID, String name, OffsetDateTime dateOfBirth,
      OffsetDateTime startDate, String gender, BigDecimal salary, String position) {
    record = Employee.EMPLOYEE.newRecord();
    record.setBranchid(branchID);
    record.setName(name);
    record.setDateofbirth(dateOfBirth);
    record.setStartdate(startDate);
    record.setGender(gender);
    record.setSalary(salary);
    record.setPosition(position);
  }

  public EmployeeDbO(EmployeeRecord record) {
    this.record = record;
  }
}
