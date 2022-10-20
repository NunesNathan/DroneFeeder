package com.futuereh.dronefeeder.utils;

public enum DeliveryType {
  WITHDRAW, DELIVERY;

  /** check if a string is a delivery type.*/
  public static boolean isType(String text) {
    for (DeliveryType type : DeliveryType.values()) {
      if (type.toString().equals(text)) {
        return true;
      }
    }
    return false;
  }
}
