package com.futuereh.dronefeeder.exception.exceptions;

@SuppressWarnings("serial")
public class BadRequestStatus extends RuntimeException {
  public BadRequestStatus() {
    super("Bad request! Invalid status!");
  }
}