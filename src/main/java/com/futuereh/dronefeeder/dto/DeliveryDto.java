package com.futuereh.dronefeeder.dto;

public class DeliveryDto {
  private String deliveryType;

  public String getDeliveryType() {
    return deliveryType.toUpperCase();
  }

  public void setDeliveryType(String deliveryType) {
    this.deliveryType = deliveryType.toUpperCase();
  }
}
