package DesignPatterns.creational.meals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Instructions {
   List<String> instructions = new ArrayList<>();

    public void addInstruction(String instruction){
        this.instructions.add(instruction);
    }

}
