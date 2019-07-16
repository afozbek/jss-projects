package assigment2.classes.beans;

import assigment2.classes.annotations.FoodAnnotation;
import assigment2.classes.annotations.TimeAnnotation;

@FoodAnnotation(price = 22.5, desc = "PIZZA")
public class Pizza extends FoodBean implements Food {


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
