package com.parkinglot;

//ParkingSpot.java
public class ParkingSpot {
  String spotId;
  Vehicle parkedVehicle;

 public ParkingSpot(String spotId) {
     this.spotId = spotId;
     this.parkedVehicle = null;
 }

 public String getSpotId() {
     return spotId;
 }

 public boolean isOccupied() {
     return parkedVehicle != null;
 }

 public void parkVehicle(Vehicle vehicle) {
     this.parkedVehicle = vehicle;
     System.out.println(vehicle.getType() + " with license plate " + vehicle.getLicensePlate() +
             " parked at spot " + spotId);
 }

 public void unparkVehicle() {
     System.out.println(parkedVehicle.getType() + " with license plate " + parkedVehicle.getLicensePlate() +
             " left spot " + spotId);
     this.parkedVehicle = null;
 }
}

