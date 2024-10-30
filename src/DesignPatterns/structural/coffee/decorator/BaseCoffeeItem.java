package DesignPatterns.structural.coffee.decorator;

public abstract class BaseCoffeeItem implements CoffeeItem{

    private double price ;
    protected CoffeeItem item = new EmptyCoffeeItem();
    public BaseCoffeeItem(double price) {
        this.price = price;
    }

    public double price() {
        return this.item.price()+price;
    }

    @Override
    public CoffeeItem make() {
        this.item.make();
        return this;
    }

    public void addBaseCoffeeItem(CoffeeItem item){
        this.item=item;
    }
    protected abstract void makeCoffeeItem();


}
