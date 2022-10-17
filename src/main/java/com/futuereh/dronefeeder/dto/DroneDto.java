package com.futuereh.dronefeeder.dto;

import java.time.LocalDateTime;

public class DroneDto {
  private String model;
  private double latitude;
  private double longitude;

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
}
