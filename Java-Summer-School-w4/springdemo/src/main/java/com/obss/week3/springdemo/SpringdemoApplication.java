package com.obss.week3.springdemo;

import com.obss.week3.springdemo.calculator.util.PrimarySchoolCalcUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringdemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringdemoApplication.class, args);

        System.out.println("\nApplication is running correctly...");

        PrimarySchoolCalcUtil calculator = context.getBean(PrimarySchoolCalcUtil.class);

        calculator.operate();
    }
}
