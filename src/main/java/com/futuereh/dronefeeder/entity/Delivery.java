package com.futuereh.dronefeeder.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.futuereh.dronefeeder.utils.Constants;
import com.futuereh.dronefeeder.utils.DeliveryStatus;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Delivery {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String deliveryType;
  private String deliveryStatus;
  private LocalDateTime lastUpdate;
  private String deliveredConfirmationLink;
  @JsonIgnoreProperties(value = {"deliveries"})
  @ManyToOne
  private Drone drone;

  public Delivery() { }

  public Delivery(
          Drone drone,
          String deliveryType,
          String deliveryStatus
  ) {
    this.drone = drone;
    this.deliveryType = deliveryType;
    this.deliveryStatus = deliveryStatus;
    this.lastUpdate = LocalDateTime.now();
    this.deliveredConfirmationLink = "The "
            + (deliveryType + " status is: "
            + deliveryStatus + ", no download link enable").toLowerCase();
  }

  public Integer getId() {
    return id;
  }

  public Drone getDrone() {
    return drone;
  }

  public String getDeliveryType() {
    return deliveryType;
  }

  public void setDeliveryType(String deliveryType) {
    this.deliveryType = deliveryType;
  }

  public String getDeliveryStatus() {
    return deliveryStatus;
  }

  public void setDeliveryStatus(String deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }

  public String getLastUpdate() {
    return this.lastUpdate.format(Constants.format);
  }

  public void setLastUpdate(LocalDateTime lastUpdate) {
    this.lastUpdate = LocalDateTime.parse(LocalDateTime.now().format(Constants.format));
  }

  public String getDeliveredConfirmationLink() {
    return deliveredConfirmationLink;
  }

  public void setDeliveredConfirmationLink(String deliveredConfirmationLink) {
    this.deliveredConfirmationLink = deliveredConfirmationLink;
  }

  public void confirmDelivery(String videoLink) {
    setDeliveryStatus(DeliveryStatus.DELIVERED.toString());
    setDeliveredConfirmationLink(videoLink);
  }
}
