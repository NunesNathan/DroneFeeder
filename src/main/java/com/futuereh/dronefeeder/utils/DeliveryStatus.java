package com.futuereh.dronefeeder.utils;

public enum DeliveryStatus {
  PROCESSING, SHIPPED, IN_TRANSIT, DELIVERED;

  public static DeliveryStatus isStatus(String text) {
    return DeliveryStatus.valueOf(text.toUpperCase());
  }
}
