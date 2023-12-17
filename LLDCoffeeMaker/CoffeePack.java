package com.test;

import java.util.ArrayList;
import java.util.List;

// Class representing the Coffee Pack
public class CoffeePack {
    private int milkPortions;
    private int sugarPortions;

    public CoffeePack(int milkPortions, int sugarPortions) {
        this.milkPortions = milkPortions;
        this.sugarPortions = sugarPortions;
    }

    public Coffee prepareCoffee() {
        Coffee coffee = new PlainCoffee();

        for (int i = 0; i < milkPortions; i++) {
            coffee = new MilkDecorator(coffee);
        }

        for (int i = 0; i < sugarPortions; i++) {
            coffee = new SugarDecorator(coffee);
        }

        return coffee;
    }
}

