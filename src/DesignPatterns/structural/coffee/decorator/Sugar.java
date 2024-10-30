package DesignPatterns.structural.coffee.decorator;

public class Sugar extends Sweetners{


    public Sugar() {
        super(1.0);
    }

    @Override
    protected void makeCoffeeItem() {
        System.out.println("Adding sugar");

    }
}
