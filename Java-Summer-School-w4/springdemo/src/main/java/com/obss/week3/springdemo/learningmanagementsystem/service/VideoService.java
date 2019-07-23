package com.obss.week3.springdemo.learningmanagementsystem.service;

import com.obss.week3.springdemo.learningmanagementsystem.core.cache.ContentCache;
import com.obss.week3.springdemo.learningmanagementsystem.model.content.VideoContent;

public interface VideoService {
    boolean createNewVideoContent(Long id, VideoContent content);

    VideoContent deleteVideoContent(VideoContent videoContent);

    String getVideoUrl(Long id);

    void updateCurrentTime(Long id, Long duration);

    ContentCache getContentCache();
}
