package DesignPatterns.creational.meals;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MealBuilderFactory {
    static Map<String, Supplier<MealBuilder>> builders = new HashMap<>();
    static {
        builders.put("DOMINOES",DOMINOESMealBuilder::new);
    }
    static MealBuilder createMealBuilder(String type){
        if(!builders.containsKey(type)) throw new IllegalArgumentException();
        return builders.get(type).get();
    }
}
