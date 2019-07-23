package com.obss.week3.springdemo.learningmanagementsystem.service;

import com.obss.week3.springdemo.learningmanagementsystem.core.cache.ContentCache;
import com.obss.week3.springdemo.learningmanagementsystem.model.content.ElearningContent;

public interface ElearningService {
    boolean createNewElearningContent(Long id, ElearningContent content);

    ElearningContent deleteElearningContent(ElearningContent content);

    String getElearningUrl(Long id);

    ContentCache getContentCache();
}
