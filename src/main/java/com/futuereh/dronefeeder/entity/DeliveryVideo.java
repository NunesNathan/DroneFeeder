package com.futuereh.dronefeeder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DeliveryVideo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @OneToOne
  private Delivery delivery;
  private String deliveredConfirmationLink;

  public DeliveryVideo() { }

  public Integer getId() {
    return id;
  }

  public Integer getDelivery() {
    return delivery.getId();
  }

  public void setDelivery(Delivery delivery) {
    this.delivery = delivery;
  }

  public String getDeliveredConfirmationLink() {
    return deliveredConfirmationLink;
  }

  public void setDeliveredConfirmationLink(String deliveredConfirmationLink) {
    this.deliveredConfirmationLink = deliveredConfirmationLink;
  }
}
