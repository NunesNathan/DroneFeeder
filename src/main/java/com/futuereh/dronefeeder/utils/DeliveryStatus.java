package com.futuereh.dronefeeder.utils;

public enum DeliveryStatus {
  PROCESSING, SHIPPED, IN_TRANSIT, DELIVERED;

  public static boolean isStatus(String text) {
    for (DeliveryStatus stts : DeliveryStatus.values()) {
      if (stts.toString().equals(text)) {
        return true;
      }
    }
    return false;
  }
}
