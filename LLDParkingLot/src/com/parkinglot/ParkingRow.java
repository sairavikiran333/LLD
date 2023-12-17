package com.parkinglot;

//ParkingRow.java
import java.util.ArrayList;
import java.util.List;

public class ParkingRow {
 private List<ParkingSpot> spots;

 public ParkingRow(int numSpots) {
     spots = new ArrayList<>(numSpots);
     for (int i = 0; i < numSpots; i++) {
         spots.add(new ParkingSpot("Spot_" + i));
     }
 }

 public List<ParkingSpot> getSpots() {
     return spots;
 }
}

