package com.parkinglot;

//ParkingLevel.java
import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {
 private List<ParkingRow> rows;

 public ParkingLevel(int numRows, int numSpotsPerRow) {
     rows = new ArrayList<>(numRows);
     for (int i = 0; i < numRows; i++) {
         rows.add(new ParkingRow(numSpotsPerRow));
     }
 }

 public List<ParkingRow> getRows() {
     return rows;
 }
}
