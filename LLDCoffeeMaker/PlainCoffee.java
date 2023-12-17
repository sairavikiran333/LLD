package com.test;

import java.util.ArrayList;
import java.util.List;

// Concrete Component representing Plain Coffee
public class PlainCoffee implements Coffee {
    @Override
    public double getCost() {
        return 2.0;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Plain Coffee");
        return ingredients;
    }
}