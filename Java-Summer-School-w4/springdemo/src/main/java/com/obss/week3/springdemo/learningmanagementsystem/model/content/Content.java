package com.obss.week3.springdemo.learningmanagementsystem.model.content;

import java.util.Date;

public abstract class Content {
    private Long id;
    private String name;
    private String url;
    private Date publishDate;
    private Date endDate;
    private double successRatio;

    public Content() {
    }

    public Content(Long id) {
        this.id = id;
    }

    public Content(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Content(Long id, String name, String url, Date publishDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.publishDate = publishDate;
        this.endDate = endDate;
    }

    public Content(Long id, String name, String url, Date publishDate, Date endDate, Double ratio) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
        this.endDate = endDate;
        this.successRatio = ratio;
    }

    public abstract void calculateSuccess();

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", publishDate=" + publishDate +
                ", endDate=" + endDate +
                ", successRatio=" + successRatio +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getSuccessRatio() {
        return successRatio;
    }

    public void setSuccessRatio(double successRatio) {
        this.successRatio = successRatio;
    }
}
