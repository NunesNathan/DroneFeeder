package com.futuereh.dronefeeder.exception.exceptions;

@SuppressWarnings("serial")
public class BadRequestType extends RuntimeException {
  public BadRequestType() {
    super("Bad request! Invalid type!");
  }
}