package com.example.PetCare.app.usecase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PetCare.domain.entity.ServiceOrderDbO;
import com.example.PetCare.domain.entity.ServiceRecordDbO;
import com.example.PetCare.infrastructure.repository.ServiceOrderRepository;
import com.example.PetCare.infrastructure.repository.ServiceRecordRepository;

@Service
public class CreateServiceOrderUseCase {
  @Autowired
  private ServiceOrderRepository serviceOrderRepository;

  @Autowired
  private ServiceRecordRepository serviceRecordRepository;

  public CreateServiceOrderResponse execute(CreateServiceOrderRequest request) {
    var order = new ServiceOrderDbO(request.visitID, request.petID, request.serviceID, request.note,
        request.state);
    if (serviceOrderRepository.save(order) == true) {
      var record = new ServiceRecordDbO(order.record.getOrderid());
      if (serviceRecordRepository.save(record) == true) {
        return new CreateServiceOrderResponse(true, "Create new order service sucessfully");
      } else {
        return new CreateServiceOrderResponse(false, "Failed to create new order service, error ServiceRecord");
      }
    } else {
      return new CreateServiceOrderResponse(false, "Failed to create new order service");
    }
  }

  public record CreateServiceOrderRequest(UUID visitID, UUID petID, UUID serviceID, String note,
      String state) {
  }

  public record CreateServiceOrderResponse(boolean success, String message) {
  }
}
