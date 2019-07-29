package assigment2.classes.beans;

import assigment2.classes.annotations.FoodAnnotation;
import assigment2.classes.annotations.TimeAnnotation;
import assigment2.classes.interfaces.IFood;

@FoodAnnotation(price = 30, desc = "SUSHI")
public class Sushi extends Food implements IFood {

    @TimeAnnotation(takes = 27)
    public void prepare() {
    }

    @TimeAnnotation(takes = 10)
    public void cook() {
    }

    @TimeAnnotation(takes = 17)
    public void send() {
    }
}

