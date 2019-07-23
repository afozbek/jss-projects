package com.obss.week3.springdemo.calculator.component;

import com.obss.week3.springdemo.calculator.ICalculator;
import org.springframework.stereotype.Component;

@Component
public class ScientificCalculator implements ICalculator {

    public ScientificCalculator() {
        System.out.println("Scientific Constructor");
    }

    @Override
    public double sum(double num1, double num2) {
        System.out.println("Calculating...");
        return num1 + num2;
    }
}
