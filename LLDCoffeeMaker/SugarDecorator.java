package com.test;

import java.util.List;

//Concrete Decorator representing Sugar
public class SugarDecorator extends CoffeeDecorator {
 public SugarDecorator(Coffee decoratedCoffee) {
     super(decoratedCoffee);
 }

 @Override
 public double getCost() {
     return super.getCost() + 0.5;
 }

 @Override
 public List<String> getIngredients() {
     List<String> ingredients = super.getIngredients();
     ingredients.add("Sugar");
     return ingredients;
 }
}

