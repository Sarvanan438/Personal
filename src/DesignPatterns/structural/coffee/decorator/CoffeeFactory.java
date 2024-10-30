package DesignPatterns.structural.coffee.decorator;

import java.util.Optional;

public class CoffeeFactory {

    public static CoffeeItem createCoffeeItem(String type, Optional<CoffeeItem> item){
       BaseCoffeeItem newLayerItem=new EmptyCoffeeItem();
        switch (type){
            case "ALMOND":
                newLayerItem= new AlmondMilk();
            case "SUGAR":
                newLayerItem= new Sugar();
            case "VANILLA":
                newLayerItem = new Vanilla();
        }
        if(item.isPresent()) {
            newLayerItem.addBaseCoffeeItem(item.get());
        }
        throw new IllegalArgumentException();
    }
}
