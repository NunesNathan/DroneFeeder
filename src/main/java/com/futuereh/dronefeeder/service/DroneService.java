package com.futuereh.dronefeeder.service;

import com.futuereh.dronefeeder.dto.DroneDto;
import com.futuereh.dronefeeder.entity.Delivery;
import com.futuereh.dronefeeder.entity.Drone;
import com.futuereh.dronefeeder.exception.exceptions.BadRequestDrone;
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

  /** get one drone using self id.*/
  public Drone getDrone(Integer droneId) {
    try {
      return droneRepository.findById(droneId).orElseThrow(Exception::new);
    } catch (Exception e) {
      throw new BadRequestDrone("find");
    }
  }

  /** update one drone using self id and a drone dto.*/
  public Drone updateDrone(Integer droneId, DroneDto droneDto) {
    try {
      Drone drone = droneRepository
              .findById(droneId).orElseThrow(RuntimeException::new);

      return droneRepository.save(drone.updateDrone(droneDto));
    } catch (Exception e) {
      throw new BadRequestDrone("update");
    }
  }

  /** delete one drone using self id.*/
  public void deleteDrone(Integer droneId) {
    try {
      droneRepository.findById(droneId).orElseThrow(RuntimeException::new);

      droneRepository.deleteById(droneId);
    } catch (Exception e) {
      throw new BadRequestDrone("delete");
    }
  }

  /** get all deliveries by a drone.*/
  public List<Delivery> getDroneDeliveries(Integer droneId) {
    try {
      Drone drone = droneRepository
              .findById(droneId).orElseThrow(RuntimeException::new);

      return drone.getDeliveries();
    } catch (Exception e) {
      throw new BadRequestDrone("get all deliveries of");
    }
  }
}
