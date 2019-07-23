package com.obss.week3.springdemo.learningmanagementsystem.model.content;

import org.springframework.stereotype.Component;

@Component
public class VideoContent extends Content {
    @Override
    public void calculateSuccess() {

        if (super.getSuccessRatio() > 45) {
            System.out.println("Congratulations 🎉🎉...");
        } else {
            System.out.println("You failed 😢😢..");
        }
    }
}
