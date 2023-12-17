package com.parkinglot;

//ParkingLot.java
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
 private List<ParkingLevel> levels;

 public ParkingLot(int numLevels, int numRows, int numSpotsPerRow) {
     levels = new ArrayList<>(numLevels);
     for (int i = 0; i < numLevels; i++) {
         levels.add(new ParkingLevel(numRows, numSpotsPerRow));
     }
 }

 public boolean parkVehicle(Vehicle vehicle) {
     for (ParkingLevel level : levels) {
         for (ParkingRow row : level.getRows()) {
             for (ParkingSpot spot : row.getSpots()) {
                 if (!spot.isOccupied()) {
                     spot.parkVehicle(vehicle);
                     return true;
                 }
             }
         }
     }
     System.out.println("No available spot for " + vehicle.getType() + " with license plate " +
             vehicle.getLicensePlate());
     return false;
 }

 public void unparkVehicle(Vehicle vehicle) {
     for (ParkingLevel level : levels) {
         for (ParkingRow row : level.getRows()) {
             for (ParkingSpot spot : row.getSpots()) {
                 if (spot.isOccupied() && spot.parkedVehicle == vehicle) {
                     spot.unparkVehicle();
                     return;
                 }
             }
         }
     }
     System.out.println("Vehicle " + vehicle.getType() + " with license plate " +
             vehicle.getLicensePlate() + " not found in the parking lot");
 }

}