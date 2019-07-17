package assigment2.classes.beans;

import assigment2.classes.annotations.FoodAnnotation;
import assigment2.classes.annotations.TimeAnnotation;
import assigment2.classes.interfaces.IFood;

@FoodAnnotation(price = 12.5, desc = "KEBAB")
public class Kebab extends Food implements IFood {

    @TimeAnnotation(takes = 12)
    public void prepare() {
        System.out.println("Preparing Kebab...");
    }

    @TimeAnnotation(takes = 20)
    public void cook() {
        System.out.println("Cooking Kebab...");
    }

    @TimeAnnotation(takes = 10)
    public void send() {
        System.out.println("Kebab is ready ...");
    }
}
