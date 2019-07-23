package com.obss.week3.springdemo.learningmanagementsystem.model.content;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ElearningContent extends Content {
    public ElearningContent() {
    }

    public ElearningContent(Long id) {
        super(id);
    }

    public ElearningContent(Long id, String name, String url) {
        super(id, name, url);
    }

    public ElearningContent(Long id, String name, String url, Date publishDate, Date endDate) {
        super(id, name, url, publishDate, endDate);
    }

    @Override
    public void calculateSuccess() {

        if (super.getSuccessRatio() > 20) {
            System.out.println("Congratulations 🎉🎉...");
        } else {
            System.out.println("You failed 😢😢..");
        }
    }
}
