package com.obss.week3.springdemo.learningmanagementsystem.service.impl;

import com.obss.week3.springdemo.learningmanagementsystem.core.cache.ContentCache;
import com.obss.week3.springdemo.learningmanagementsystem.model.content.Content;
import com.obss.week3.springdemo.learningmanagementsystem.model.content.VideoContent;
import com.obss.week3.springdemo.learningmanagementsystem.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private ContentCache contentCache;

    @Override
    public boolean createNewVideoContent(Long id, VideoContent content) {
        return contentCache.addContent(id, content);
    }

    @Override
    public VideoContent deleteVideoContent(VideoContent videoContent) {
        contentCache.removeContent(videoContent);

        return videoContent;
    }

    @Override
    public String getVideoUrl(Long id) {
        Content content = contentCache.getContent(id);

        return content.getUrl();
    }

    @Override
    public void updateCurrentTime(Long id, Long duration) {

    }

    @Override
    public ContentCache getContentCache() {
        return contentCache;
    }
}
