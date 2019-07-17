package assigment2.classes.beans;

import assigment2.classes.annotations.FoodAnnotation;
import assigment2.classes.annotations.TimeAnnotation;
import assigment2.classes.interfaces.IFood;

@FoodAnnotation(price = 30, desc = "SUSHI")
public class Sushi extends Food implements IFood {


    @TimeAnnotation(takes = 30)
    public void prepare() {

    }

    public void cook() {

    }

    @TimeAnnotation(takes = 20)
    public void send() {

    }
}
