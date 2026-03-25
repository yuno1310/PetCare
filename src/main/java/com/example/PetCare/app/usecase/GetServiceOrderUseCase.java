package com.example.PetCare.app.usecase;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PetCare.infrastructure.repository.ServiceOrderRepository;

@Service
public class GetServiceOrderUseCase {
  @Autowired
  private ServiceOrderRepository serviceOrderRepository;

  public GetServiceOrderResponse getPending(GetServiceOrderRequest request) {
    var orders = serviceOrderRepository.getPendingList(request.branchID);
    if (orders != null && !orders.isEmpty()) {
      var list = new ArrayList<Orders>();
      for (var item : orders) {
        list.add(new Orders(item.orderID, item.petName, item.serviceName, item.timeIn));
      }
      return new GetServiceOrderResponse(true, "Get pending list successfully", list);
    } else {
      return new GetServiceOrderResponse(false, "No pending order found", null);
    }
  }

  public record GetServiceOrderRequest(UUID branchID) {
  }

  public record GetServiceOrderResponse(boolean success, String message, List<Orders> listOrders) {
  }

  public record Orders(UUID orderID, String petName, String serviceName, OffsetDateTime timeIn) {
  }
}
