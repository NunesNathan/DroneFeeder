package com.futuereh.dronefeeder.service;

import com.futuereh.dronefeeder.dto.DroneDto;
import com.futuereh.dronefeeder.entity.Delivery;
import com.futuereh.dronefeeder.entity.Drone;
import com.futuereh.dronefeeder.repository.DroneRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneService {
  @Autowired
  DroneRepository droneRepository;

  /** save a drone using a drone dto.*/
  public Drone addDrone(DroneDto droneDto) {
    Drone drone = new Drone(droneDto.getModel(),
            droneDto.getLatitude(),
            droneDto.getLongitude());

    droneRepository.save(drone);

    return drone;
  }

  public List<Drone> getDrones() {
    return droneRepository.findAll();
  }

  public Drone getDrone(Integer droneId) {
    return droneRepository.findById(droneId).orElseThrow(RuntimeException::new);
  }

  /** update one drone using self id and a drone dto.*/
  public Drone updateDrone(Integer droneId, DroneDto droneDto) {
    Drone drone = droneRepository
            .findById(droneId).orElseThrow(RuntimeException::new);

    return drone.updateDrone(droneDto);
  }

  /** delete one drone using self id.*/
  public void deleteById(Integer droneId) {
    droneRepository.findById(droneId).orElseThrow(RuntimeException::new);

    droneRepository.deleteById(droneId);
  }

  /** get all deliveries by a drone.*/
  public List<Delivery> getDroneDeliveries(Integer droneId) {
    Drone drone = droneRepository
            .findById(droneId).orElseThrow(RuntimeException::new);

    return drone.getDeliveries();
  }
}
