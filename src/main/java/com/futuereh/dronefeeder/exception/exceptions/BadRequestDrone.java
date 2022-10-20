package com.futuereh.dronefeeder.exception.exceptions;

@SuppressWarnings("serial")
public class BadRequestDrone extends RuntimeException {
  public BadRequestDrone(String s) {
    super("Bad request! Unable to " + s + " this drone!");
  }
}