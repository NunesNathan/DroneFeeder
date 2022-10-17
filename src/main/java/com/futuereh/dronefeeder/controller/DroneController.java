package com.futuereh.dronefeeder.controller;

import com.futuereh.dronefeeder.dto.DroneDto;
import com.futuereh.dronefeeder.entity.Drone;
import com.futuereh.dronefeeder.service.DroneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
