package com.obss.week3.springdemo.learningmanagementsystem.core.cache;

import com.obss.week3.springdemo.learningmanagementsystem.model.content.Content;


public interface ContentCache {
    Content getContent(Long id);

    boolean addContent(Long id, Content content);

    Content removeContent(Content content);

    void printCacheSize();
}
