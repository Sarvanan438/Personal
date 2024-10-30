package DesignPatterns.creational.meals;

import java.util.Map;

public interface MealBuilder {
    public MealBuilder  mainCourse(String[] mainCourseId);
    public MealBuilder sideDish(String[] sideDishId);
    public MealBuilder  beverage(String[] beverageIds);
    // encapsulate the map into a class which helps with boundaries of clean code , better that way
    public MealBuilder addInstruction (String instruction);

}
