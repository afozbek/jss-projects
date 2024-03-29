package com.obss.week3.springdemo.calculator.util;

import com.obss.week3.springdemo.calculator.ICalculator;
import com.obss.week3.springdemo.calculator.IHesapla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PrimarySchoolCalcUtil implements IHesapla {

    private ICalculator calculator;

    @Autowired
    public PrimarySchoolCalcUtil(@Qualifier("simple") ICalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public double operate() {
        return calculator.sum(15, 15);
    }
}
