package com.obss.week3.springdemo.calculator;

import org.springframework.stereotype.Component;

@Component
public class ScientificCalculator implements ICalculator {

    @Override
    public double sum(double num1, double num2) {
        System.out.println("Calculating...");
        return num1 + num2;
    }
}
