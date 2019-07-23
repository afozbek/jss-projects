package com.obss.week3.springdemo.learningmanagementsystem;

import com.obss.week3.springdemo.SpringdemoApplication;
import com.obss.week3.springdemo.learningmanagementsystem.model.content.ElearningContent;
import com.obss.week3.springdemo.learningmanagementsystem.model.content.VideoContent;
import com.obss.week3.springdemo.learningmanagementsystem.service.impl.ElearningServiceImpl;
import com.obss.week3.springdemo.learningmanagementsystem.service.impl.VideoServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ScopeApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringdemoApplication.class, args);
        System.out.println("\nApplication is running correctly...");

        ElearningContent elearningContent = context.getBean(ElearningContent.class);
        VideoContent videoContent = context.getBean(VideoContent.class);

        ElearningServiceImpl elearningService = context.getBean(ElearningServiceImpl.class);
        VideoServiceImpl videoService = context.getBean(VideoServiceImpl.class);

        elearningService.createNewElearningContent((long) 1, elearningContent);
        elearningService.createNewElearningContent((long) 2, elearningContent);
        elearningService.createNewElearningContent((long) 3, elearningContent);
        elearningService.createNewElearningContent((long) 4, elearningContent);

        videoService.createNewVideoContent((long) 5, videoContent);
        videoService.createNewVideoContent((long) 6, videoContent);

        elearningService.getContentCache().printCacheSize();
        videoService.getContentCache().printCacheSize();
    }
}
