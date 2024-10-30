package DesignPatterns.structural.coffee.decorator;

public class Vanilla extends FlavourShots{
    public Vanilla() {
        super(5.00);
    }

    @Override
    protected void makeCoffeeItem() {
        System.out.println("Adding vanilla flavour shots");
    }
}
