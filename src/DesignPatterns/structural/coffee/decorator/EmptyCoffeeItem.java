package DesignPatterns.structural.coffee.decorator;

public class EmptyCoffeeItem extends BaseCoffeeItem{
    public EmptyCoffeeItem() {
        super(0.0);
    }



    @Override
    protected void makeCoffeeItem() {
        System.out.println("base cup");
    }
}
