package com.obss.week3.springdemo.learningmanagementsystem.service.impl;

import com.obss.week3.springdemo.learningmanagementsystem.core.cache.ContentCache;
import com.obss.week3.springdemo.learningmanagementsystem.model.content.Content;
import com.obss.week3.springdemo.learningmanagementsystem.model.content.ElearningContent;
import com.obss.week3.springdemo.learningmanagementsystem.service.ElearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElearningServiceImpl implements ElearningService {

    @Autowired
    private ContentCache contentCache;

    @Override
    public boolean createNewElearningContent(Long id, ElearningContent content) {
        contentCache.addContent(id, content);

        return true;
    }

    @Override
    public ElearningContent deleteElearningContent(ElearningContent content) {
        contentCache.removeContent(content);

        return content;
    }

    @Override
    public String getElearningUrl(Long id) {
        Content content = contentCache.getContent(id);

        return content.getUrl();
    }


    @Override
    public ContentCache getContentCache() {
        return contentCache;
    }
}
