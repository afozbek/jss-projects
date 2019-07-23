package com.obss.week3.springdemo.learningmanagementsystem.core.cache.impl;

import com.obss.week3.springdemo.learningmanagementsystem.core.cache.ContentCache;
import com.obss.week3.springdemo.learningmanagementsystem.model.content.Content;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Scope("prototype")
public class InMemoryContentCache implements ContentCache {

    private Map<Long, Content> contentCache = new ConcurrentHashMap<>();

    @Override
    public Content getContent(Long id) {
        return contentCache.get(id);
    }

    @Override
    public boolean addContent(Long id, Content content) {
        if (!contentCache.containsKey(id)) {
            contentCache.put(id, content);

            return true;
        }
        return false;
    }

    @Override
    public Content removeContent(Content content) {
        return contentCache.remove(content);
    }

    @Override
    public void printCacheSize() {
        System.out.println("Current Cache Size: " + contentCache.size());
    }
}
