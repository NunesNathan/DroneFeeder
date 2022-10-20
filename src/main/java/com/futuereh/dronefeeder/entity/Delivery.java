package com.futuereh.dronefeeder.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.futuereh.dronefeeder.dto.UpdateDeliveryStatusDto;
import com.futuereh.dronefeeder.utils.Constants;
import com.futuereh.dronefeeder.utils.DeliveryStatus;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Delivery {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String deliveryType;
  private String deliveryStatus;
  private LocalDateTime createOrder;
  private LocalDateTime lastUpdate;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "confirmationLink")
  private DeliveryVideo deliveredConfirmationLink;
  @JsonIgnoreProperties(value = {"deliveries"})
  @ManyToOne
  private Drone drone;

  public Delivery() { }

  /** Delivery contructor.
   *
   * @param drone Owner delivery drone
   * @param deliveryType Delivery type
   * @param dv Delivery video
   */
  public Delivery(
          Drone drone,
          String deliveryType,
          DeliveryVideo dv
  ) {
    String deliveryStatus = DeliveryStatus.PROCESSING.toString();
    dv.setDeliveredConfirmationLink("The "
            + (deliveryType + " status is: "
            + deliveryStatus + ", no download link avaliable").toLowerCase());

    this.drone = drone;
    this.deliveryType = deliveryType;
    this.deliveryStatus = deliveryStatus;
    this.createOrder = LocalDateTime.now();
    this.lastUpdate = LocalDateTime.now();
    this.deliveredConfirmationLink = dv;

    this.setDeliveryVideoDelivery();
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

  public String getCreateOrder() {
    return createOrder.format(Constants.format);
  }

  public void setCreateOrder(LocalDateTime createOrder) {
    this.createOrder = createOrder;
  }

  public String getLastUpdate() {
    return this.lastUpdate.format(Constants.format);
  }

  public void setLastUpdate() {
    this.lastUpdate = LocalDateTime.now();
  }

  public String getDeliveredConfirmationLink() {
    return deliveredConfirmationLink.getDeliveredConfirmationLink();
  }

  public void setDeliveredConfirmationLink(String deliveredConfirmationLink) {
    this.deliveredConfirmationLink.setDeliveredConfirmationLink(deliveredConfirmationLink);
  }

  public void setDeliveryVideoDelivery() {
    this.deliveredConfirmationLink.setDelivery(this);
  }

  public void confirmDelivery(String videoLink) {
    setDeliveryStatus(DeliveryStatus.DELIVERED.toString());
    setDeliveredConfirmationLink(videoLink);
  }

  /** update this delivery using a update delivery status dto.*/
  public Delivery updateDelivery(UpdateDeliveryStatusDto updateDeliveryStatusDto) {
    this.setDeliveryStatus(updateDeliveryStatusDto.getDeliveryStatus());

    this.setDeliveredConfirmationLink("The "
            + (this.deliveryType + " status is: "
            + updateDeliveryStatusDto.getDeliveryStatus()
            + ", no download link avaliable").toLowerCase());

    if (DeliveryStatus.DELIVERED.toString().equals(updateDeliveryStatusDto.getDeliveryStatus())) {
      this.setDeliveredConfirmationLink(updateDeliveryStatusDto.getDeliveredConfirmationLink());
    }

    setLastUpdate();

    return this;
  }
}
