package DesignPatterns.creational.meals;

import java.util.Map;

public class DOMINOESMealBuilder implements MealBuilder{
    Instructions instructions = new Instructions();
    DOMINOESMealBuilder(){

    }
    @Override
    public MealBuilder mainCourse(String[] mainCourseId) {
        return this;
    }

    @Override
    public MealBuilder sideDish(String[] sideDishId) {
        return this;
    }

    @Override
    public MealBuilder beverage(String[] beverageIds) {
        return this;
    }

    @Override
    public MealBuilder addInstruction(String instruction) {
        this.instructions.addInstruction(instruction);
        return this;
    }
}
