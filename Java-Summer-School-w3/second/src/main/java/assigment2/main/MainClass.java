package assigment2.main;

import assigment2.classes.annotations.FoodAnnotation;
import assigment2.classes.annotations.TimeAnnotation;
import assigment2.classes.beans.Food;
import assigment2.classes.beans.Kebab;
import assigment2.classes.beans.Pizza;
import assigment2.classes.beans.Sushi;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) {
        ArrayList<Food> foods = new ArrayList<Food>();

        foods.add(new Pizza());
        foods.add(new Sushi());
        foods.add(new Kebab());

        for (Food food : foods) {
            int time = 0;
            FoodAnnotation foodAnnotation = food.getClass().getAnnotation(FoodAnnotation.class);
            food.setName(foodAnnotation.desc());
            food.setPrice(foodAnnotation.price());

            Method[] methods = food.getClass().getDeclaredMethods();

            for (Method method : methods) {
                TimeAnnotation annotation = method.getAnnotation(TimeAnnotation.class);
                if (annotation != null) {
                    time += annotation.takes();
                }
            }

            food.setTime(time);
        }

        for (Food food : foods) {
            System.out.println(food.toString());
        }

    }
}
