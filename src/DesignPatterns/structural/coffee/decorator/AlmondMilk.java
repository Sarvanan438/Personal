package DesignPatterns.structural.coffee.decorator;

public class AlmondMilk extends Milk{

    public AlmondMilk() {
        super(12.5);
    }

    @Override
    protected void makeCoffeeItem() {
        System.out.println("adding almond milk");
    }


}
