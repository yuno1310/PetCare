package com.example.PetCare.app.usecase;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PetCare.domain.entity.BranchDbO;
import com.example.PetCare.infrastructure.repository.BranchRepository;

@Service
public class CreateBracnhUseCase {
  @Autowired
  private BranchRepository branchRepository;

  public CreateBracnhResponse execute(CreateBracnhRequest request) {
    var convertOpenTime = LocalTime.parse(request.openTime);
    var converCloseTime = LocalTime.parse(request.closeTime);
    var branch = new BranchDbO(request.name, request.address, request.phoneNumber, convertOpenTime, converCloseTime);
    if (branchRepository.save(branch) == true) {
      return new CreateBracnhResponse(true, "Create new branch successfully");
    } else {
      return new CreateBracnhResponse(false, "Failed to create new branch");
    }
  }

  public record CreateBracnhRequest(String name, String address, String phoneNumber, String openTime,
      String closeTime) {
  }

  public record CreateBracnhResponse(boolean success, String message) {
  }
}
