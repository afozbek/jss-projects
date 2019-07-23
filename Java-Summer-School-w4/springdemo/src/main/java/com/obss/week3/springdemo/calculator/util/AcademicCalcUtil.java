package com.obss.week3.springdemo.calculator.util;

import com.obss.week3.springdemo.calculator.ICalculator;
import com.obss.week3.springdemo.calculator.IHesapla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AcademicCalcUtil implements IHesapla {

    private ICalculator calculator;

    @Autowired
    public AcademicCalcUtil(@Qualifier("scientificCalculator") ICalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public double operate() {
        return calculator.sum(5, 6);
    }
}
