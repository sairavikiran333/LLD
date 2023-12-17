package com.test;

import java.util.List;

//Concrete Decorator representing Milk
public class MilkDecorator extends CoffeeDecorator {
 public MilkDecorator(Coffee decoratedCoffee) {
     super(decoratedCoffee);
 }

 @Override
 public double getCost() {
     return super.getCost() + 0.5;
 }

 @Override
 public List<String> getIngredients() {
     List<String> ingredients = super.getIngredients();
     ingredients.add("Milk");
     return ingredients;
 }
}
