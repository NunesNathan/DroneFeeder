package com.futuereh.dronefeeder.utils;

public enum DeliveryType {
  WITHDRAW, DELIVERY;

  static public DeliveryType isType(String text) {
    return DeliveryType.valueOf(text.toUpperCase());
  }
}
