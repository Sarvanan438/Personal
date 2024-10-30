package DesignPatterns.structural.coffee.decorator;

import java.util.Optional;

public class CoffeeMaker {
    public static void main(String[] args) {
        CoffeeItem coffeeItem = CoffeeFactory.createCoffeeItem("ALMOND", java.util.Optional.empty());
        coffeeItem = CoffeeFactory.createCoffeeItem("SUGAR", Optional.of(coffeeItem));
        coffeeItem = CoffeeFactory.createCoffeeItem("VANILLA",Optional.of(coffeeItem));
        System.out.println(coffeeItem.price());
        coffeeItem.make();
    }
}
