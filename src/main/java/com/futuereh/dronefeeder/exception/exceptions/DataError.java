package com.futuereh.dronefeeder.exception.exceptions;

public class DataError {
  public String error;

  public DataError(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }
}
