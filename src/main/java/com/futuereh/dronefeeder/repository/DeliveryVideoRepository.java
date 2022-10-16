package com.futuereh.dronefeeder.repository;

import com.futuereh.dronefeeder.entity.DeliveryVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryVideoRepository extends JpaRepository<DeliveryVideo, Integer> {
}
