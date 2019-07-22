package com.obss.week3.springdemo.calculator.util;

import com.obss.week3.springdemo.calculator.ICalculator;
import com.obss.week3.springdemo.calculator.IHesapla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AcademicCalcUtil implements IHesapla {

    @Autowired
    @Qualifier("scientificCalculator")
    private ICalculator scientificCalculator;


    @Override
    public double operate() {
        return scientificCalculator.sum(5, 6);
    }
}
