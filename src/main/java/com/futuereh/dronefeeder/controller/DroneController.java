package com.futuereh.dronefeeder.controller;

import com.futuereh.dronefeeder.dto.DroneDto;
import com.futuereh.dronefeeder.entity.Drone;
import com.futuereh.dronefeeder.service.DroneService;
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
@RequestMapping("/drones")
public class DroneController {
  @Autowired
  DroneService droneService;

  @PostMapping
  public ResponseEntity<Drone> addDrone(@RequestBody DroneDto droneDto) {
    return ResponseEntity.status(201).body(droneService.addDrone(droneDto));
  }

  @GetMapping
  public ResponseEntity<List<Drone>> getDrones() {
    return ResponseEntity.ok(droneService.getDrones());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Drone> getDrone(@PathVariable("id") Integer droneId) {
    return ResponseEntity.ok(droneService.getDrone(droneId));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Drone> updateDrone(@PathVariable("id") Integer droneId,
                           @RequestBody DroneDto droneDto) {
    return ResponseEntity.ok(droneService.updateDrone(droneId, droneDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Drone> deleteDrone(@PathVariable("id") Integer droneId) {
    droneService.deleteById(droneId);
    return ResponseEntity.noContent().build();
  }
}
