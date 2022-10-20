package com.futuereh.dronefeeder.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.futuereh.dronefeeder.dto.DroneDto;
import com.futuereh.dronefeeder.utils.Constants;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Drone {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String model;
  private LocalDateTime lastComponentsReview;
  private double latitude;
  private double longitude;
  @OneToMany(mappedBy = "drone", cascade = CascadeType.ALL)
  @JsonIgnoreProperties(value = {"drone"})
  private List<Delivery> deliveries = new ArrayList<>();

  public Drone() { }

  /** Drone Contructor.
   *
   * @param model Drone model.
   * @param latitude Drone latitude.
   * @param longitude Drone longitude.
   */
  public Drone(String model, double latitude, double longitude) {
    this.model = model;
    this.lastComponentsReview = LocalDateTime.now();
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Integer getId() {
    return id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getLastComponentsReview() {
    return this.lastComponentsReview.format(Constants.format);
  }

  public void componentsReviewed() {
    this.lastComponentsReview = LocalDateTime.now();
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

  public void setCordinates(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  private Map<Double, Double> getCordinates() {
    return Map.of(this.latitude, this.longitude);
  }

  public List<Delivery> getDeliveries() {
    return deliveries;
  }

  public void addDelivery(Delivery deliveries) {
    this.deliveries.add(deliveries);
  }

  /** update this drone using a drone dto.*/
  public Drone updateDrone(DroneDto droneDto) {
    this.setModel(droneDto.getModel());
    this.setCordinates(droneDto.getLatitude(), droneDto.getLongitude());

    return this;
  }
}
