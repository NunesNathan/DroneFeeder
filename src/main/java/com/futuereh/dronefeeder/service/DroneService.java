package com.futuereh.dronefeeder.service;

import com.futuereh.dronefeeder.dto.DroneDto;
import com.futuereh.dronefeeder.entity.Drone;
import com.futuereh.dronefeeder.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneService {
  @Autowired
  DroneRepository droneRepository;

  /** add one drone using a drone dto.*/
  public Drone addDrone(DroneDto droneDto) {
    Drone drone = new Drone(droneDto.getModel(),
            droneDto.getLatitude(),
            droneDto.getLongitude());

    droneRepository.save(drone);

    return drone;
  }
}
