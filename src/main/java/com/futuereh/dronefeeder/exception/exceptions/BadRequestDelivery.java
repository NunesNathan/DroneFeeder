package com.futuereh.dronefeeder.exception.exceptions;

@SuppressWarnings("serial")
public class BadRequestDelivery extends RuntimeException {
  public BadRequestDelivery(String s) {
    super("Bad request! Unable to " + s + " this delivery!");
  }
}