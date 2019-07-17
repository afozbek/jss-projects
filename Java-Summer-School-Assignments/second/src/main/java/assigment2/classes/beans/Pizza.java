package assigment2.classes.beans;

import assigment2.classes.annotations.FoodAnnotation;
import assigment2.classes.annotations.TimeAnnotation;
import assigment2.classes.interfaces.IFood;

@FoodAnnotation(price = 22.5, desc = "PIZZA")
public class Pizza extends Food implements IFood {


    @TimeAnnotation(takes = 10)
    public void prepare() {

    }

    @TimeAnnotation(takes = 20)
    public void cook() {

    }

    @TimeAnnotation(takes = 15)
    public void send() {

    }
}
