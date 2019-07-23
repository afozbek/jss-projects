package com.obss.week3.springdemo.calculator.component;

import com.obss.week3.springdemo.calculator.ICalculator;
import org.springframework.stereotype.Component;

@Component(value = "simple")
public class SimpleCalculator implements ICalculator {

    public SimpleCalculator() {
        System.out.println("Simple Constructor");
    }

    @Override
    public double sum(double num1, double num2) {
        System.out.println("Calculating...");
        return num1 + num2;
    }
}
