package com.futuereh.dronefeeder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DeliveryVideo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String confirmationLink;

  public DeliveryVideo() { }

  public Integer getId() {
    return id;
  }

  public String getConfirmationLink() {
    return confirmationLink;
  }

  public void setConfirmationLink(String confirmationLink) {
    this.confirmationLink = confirmationLink;
  }
}
