package com.test;

public class Client {

	// Client class
	    public static void main(String[] args) {
	        // Example input
	        CoffeePack coffeePack = new CoffeePack(2, 3);

	        // Making coffee
	        Coffee coffee = coffeePack.prepareCoffee();

	        // Displaying output
	        System.out.println("Cost for this coffee is: " + coffee.getCost());
	        System.out.println("Ingredients for this coffee are: " + String.join(", ", coffee.getIngredients()));
	    }

}
