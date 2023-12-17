package com.parkinglot;

public class Client {

	public static void main(String[] args) {
		

	     ParkingLot parkingLot = new ParkingLot(1, 1, 0);

	     Vehicle motorcycle = new Motorcycle("Moto_1");
	     parkingLot.parkVehicle(motorcycle);

	     Vehicle car = new Car("Car_1");
	     parkingLot.parkVehicle(car);

	     Vehicle bus = new Bus("Bus_1");
	     parkingLot.parkVehicle(bus);

	     parkingLot.unparkVehicle(car);

	     parkingLot.parkVehicle(bus);
	 

	}

}
