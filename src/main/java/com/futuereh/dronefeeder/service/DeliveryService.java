package com.futuereh.dronefeeder.service;

import com.futuereh.dronefeeder.dto.DeliveryDto;
import com.futuereh.dronefeeder.dto.UpdateDeliveryStatusDto;
import com.futuereh.dronefeeder.entity.Delivery;
import com.futuereh.dronefeeder.entity.DeliveryVideo;
import com.futuereh.dronefeeder.entity.Drone;
import com.futuereh.dronefeeder.repository.DeliveryRepository;
import com.futuereh.dronefeeder.repository.DeliveryVideoRepository;
import com.futuereh.dronefeeder.utils.DeliveryStatus;
import com.futuereh.dronefeeder.utils.DeliveryType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
  @Autowired
  DeliveryRepository deliveryRepository;

  @Autowired
  DeliveryVideoRepository deliveryVideoRepository;

  @Autowired
  DroneService droneService;

  /** save a delivery video and a delivery.*/
  public Delivery addDelivery(Integer id, DeliveryDto deliveryDto) {
    DeliveryVideo dv = deliveryVideoRepository.save(new DeliveryVideo());

    Drone findedDrone = droneService.getDrone(id);

    Delivery delivery = new Delivery(findedDrone,
            DeliveryType.isType(deliveryDto.getDeliveryType()).toString(),
            dv);

    return deliveryRepository.save(delivery);
  }

  public List<Delivery> getDeliveries() {
    return deliveryRepository.findAll();
  }

  public Delivery getDelivery(Integer delivery) {
    return deliveryRepository.findById(delivery).orElseThrow(RuntimeException::new);
  }

  /** update one delivery using self id and a delivery dto.*/
  public Delivery updateDeliveryStatus(Integer deliveryId, UpdateDeliveryStatusDto updateDeliveryStatusDto) {
    if (DeliveryStatus.isStatus(updateDeliveryStatusDto.getDeliveryStatus())) {
      Delivery delivery = deliveryRepository
              .findById(deliveryId).orElseThrow(RuntimeException::new);

      return deliveryRepository.save(delivery.updateDelivery(updateDeliveryStatusDto));
    }
    throw new RuntimeException();
  }

  public List<DeliveryVideo> getAllLinks() {
    return deliveryVideoRepository.findAll();
  }
}
