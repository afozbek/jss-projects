package assigment2.classes.beans;

import assigment2.classes.annotations.FoodAnnotation;
import assigment2.classes.annotations.TimeAnnotation;
import assigment2.classes.interfaces.IFood;

@FoodAnnotation(price = 22.5, desc = "PIZZA")
public class Pizza extends Food implements IFood {

    @TimeAnnotation(takes = 13)
    public void prepare() {
    }

    @TimeAnnotation(takes = 26)
    public void cook() {
    }

    @TimeAnnotation(takes = 6)
    public void send() {
    }
}

