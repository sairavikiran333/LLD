package com.test;

import java.util.List;

//Decorator abstract class
public abstract class CoffeeDecorator implements Coffee {
 protected Coffee decoratedCoffee;

 public CoffeeDecorator(Coffee decoratedCoffee) {
     this.decoratedCoffee = decoratedCoffee;
 }

 @Override
 public double getCost() {
     return decoratedCoffee.getCost();
 }

 @Override
 public List<String> getIngredients() {
     return decoratedCoffee.getIngredients();
 }
}
