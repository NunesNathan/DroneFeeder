package com.futuereh.dronefeeder.controller;

import com.futuereh.dronefeeder.dto.DeliveryDto;
import com.futuereh.dronefeeder.dto.UpdateDeliveryStatusDto;
import com.futuereh.dronefeeder.entity.Delivery;
import com.futuereh.dronefeeder.entity.DeliveryVideo;
import com.futuereh.dronefeeder.entity.Drone;
import com.futuereh.dronefeeder.service.DeliveryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
  @Autowired
  DeliveryService deliveryService;

  @PostMapping("/{id}")
  public ResponseEntity<Delivery> addDelivery(@PathVariable("id") Integer id,
                            @RequestBody DeliveryDto deliveryDto) {
    return ResponseEntity.status(201)
            .body(deliveryService.addDelivery(id, deliveryDto));
  }

  @GetMapping
  public List<Delivery> getDeliveries() {
    return deliveryService.getDeliveries();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Delivery> getDelivery(@PathVariable("id") Integer deliveryId) {
    return ResponseEntity.ok(deliveryService.getDelivery(deliveryId));
  }

  /** update delivery route.*/
  @PutMapping("/{id}")
  public ResponseEntity updateDeliveryStatus(@PathVariable("id") Integer deliveryId,
                                                 @RequestBody UpdateDeliveryStatusDto
                                                         updateDeliveryStatusDto) {
    try {
      return ResponseEntity.ok(deliveryService.updateDeliveryStatus(deliveryId,
              updateDeliveryStatusDto));
    } catch (Exception e) {
      return ResponseEntity.status(400).body("Invalid status");
    }
  }

  /** delete delivery route.*/
  @DeleteMapping("/{id}")
  public ResponseEntity deleteDelivery(@PathVariable("id") Integer deliveryId) {
    try {
      deliveryService.deleteDelivery(deliveryId);

      return ResponseEntity.noContent().build();
    } catch (Exception e) {
      return ResponseEntity.status(400).body("Invalid delivery id");
    }
  }

  @GetMapping("/drone/{id}")
  public ResponseEntity<Drone> getDeliveryDrone(@PathVariable("id") Integer deliveryId) {
    return ResponseEntity.ok(deliveryService.getDeliveryDrone(deliveryId));
  }

  @GetMapping("/links")
  public List<DeliveryVideo> getAllLinks() {
    return deliveryService.getAllLinks();
  }
}
