package com.futuereh.dronefeeder.repository;

import com.futuereh.dronefeeder.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Integer> {
}
