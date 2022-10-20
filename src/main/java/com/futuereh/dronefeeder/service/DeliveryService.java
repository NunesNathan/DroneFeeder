package com.futuereh.dronefeeder.service;

import com.futuereh.dronefeeder.dto.DeliveryDto;
import com.futuereh.dronefeeder.dto.UpdateDeliveryStatusDto;
import com.futuereh.dronefeeder.entity.Delivery;
import com.futuereh.dronefeeder.entity.DeliveryVideo;
import com.futuereh.dronefeeder.entity.Drone;
import com.futuereh.dronefeeder.exception.exceptions.BadRequestDelivery;
import com.futuereh.dronefeeder.exception.exceptions.BadRequestStatus;
import com.futuereh.dronefeeder.exception.exceptions.BadRequestType;
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

    if (DeliveryType.isType(deliveryDto.getDeliveryType())) {
      Delivery delivery = new Delivery(findedDrone,
              deliveryDto.getDeliveryType(),
              dv);

      return deliveryRepository.save(delivery);
    }
    throw new BadRequestType();
  }

  public List<Delivery> getDeliveries() {
    return deliveryRepository.findAll();
  }

  /** get one delivery using self id.*/
  public Delivery getDelivery(Integer deliveryId) {
    try {
      return deliveryRepository.findById(deliveryId).orElseThrow(RuntimeException::new);
    } catch (Exception e) {
      throw new BadRequestDelivery("find");
    }
  }

  /** update one delivery using self id and a delivery dto.*/
  public Delivery updateDeliveryStatus(Integer deliveryId,
                                       UpdateDeliveryStatusDto updateDeliveryStatusDto) {
    if (DeliveryStatus.isStatus(updateDeliveryStatusDto.getDeliveryStatus())) {
      try {
        Delivery delivery = deliveryRepository
                .findById(deliveryId).orElseThrow(RuntimeException::new);

        return deliveryRepository.save(delivery.updateDelivery(updateDeliveryStatusDto));
      } catch (Exception e) {
        throw new BadRequestDelivery("find");
      }
    }
    throw new BadRequestStatus();
  }

  /** delete one delivery using self id.*/
  public void deleteDelivery(Integer deliveryId) {
    try {
      deliveryRepository.findById(deliveryId).orElseThrow(RuntimeException::new);

      deliveryRepository.deleteById(deliveryId);
    } catch (Exception e) {
      throw new BadRequestDelivery("find");
    }
  }

  /** get delivery owner drone.*/
  public Drone getDeliveryDrone(Integer deliveryId) {
    try {
      Delivery delivery = deliveryRepository.findById(deliveryId)
              .orElseThrow(RuntimeException::new);

      return delivery.getDrone();
    } catch (Exception e) {
      throw new BadRequestDelivery("find");
    }
  }

  public List<DeliveryVideo> getAllLinks() {
    return deliveryVideoRepository.findAll();
  }
}
