package com.futuereh.dronefeeder.drone;

import com.futuereh.dronefeeder.dto.DroneDto;
import com.futuereh.dronefeeder.entity.Drone;
import com.futuereh.dronefeeder.service.DroneService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DroneServiceTests {
  @Autowired
  DroneService droneService;

  @Test
  public void addDroneTest(DroneService droneService) {
    DroneDto droneDto = new DroneDto();

    droneDto.setModel("candide-h18");
    droneDto.setLatitude(-13);
    droneDto.setLongitude(-22);

    Drone drone = droneService.addDrone(droneDto);

    Assertions.assertNotNull(drone);
    Assertions.assertTrue(drone.getModel() == droneDto.getModel());
    Assertions.assertTrue(drone.getLatitude() == droneDto.getLatitude());
    Assertions.assertTrue(drone.getLongitude() == droneDto.getLongitude());
  }
}
