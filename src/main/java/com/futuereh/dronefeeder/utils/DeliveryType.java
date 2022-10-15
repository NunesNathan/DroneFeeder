package com.futuereh.dronefeeder.utils;

public enum DeliveryType {
  WITHDRAW, DELIVERY;

  public static DeliveryType isType(String text) {
    return DeliveryType.valueOf(text.toUpperCase());
  }
}
