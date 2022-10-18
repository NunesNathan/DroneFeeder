package com.futuereh.dronefeeder.dto;

import java.util.Optional;

public class UpdateDeliveryStatusDto {
  private Optional<String> deliveredConfirmationLink;

  private String deliveryStatus;

  public String getDeliveredConfirmationLink() {
    return deliveredConfirmationLink.get();
  }

  public void setDeliveredConfirmationLink(Optional<String> deliveredConfirmationLink) {
    this.deliveredConfirmationLink = deliveredConfirmationLink;
  }

  public String getDeliveryStatus() {
    return deliveryStatus.toUpperCase();
  }

  public void setDeliveryStatus(String deliveryStatus) {
    this.deliveryStatus = deliveryStatus.toUpperCase();
  }
}
