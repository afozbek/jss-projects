package com.obss.week3.springdemo.learningmanagementsystem.model.content;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ElearningContent extends Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String url;

    @Column
    private Date publishDate;

    @Column
    private Date endDate;

    @Column
    private double successRatio;


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

    public ElearningContent(Long id, String name, String url, Date publishDate, Date endDate, Double ratio) {
        super(id, name, url, publishDate, endDate, ratio);
    }


    @Override
    public String toString() {
        return "ElearningContent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", publishDate=" + publishDate +
                ", endDate=" + endDate +
                ", successRatio=" + successRatio +
                '}';
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Date getPublishDate() {
        return publishDate;
    }

    @Override
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public double getSuccessRatio() {
        return successRatio;
    }

    @Override
    public void setSuccessRatio(double successRatio) {
        this.successRatio = successRatio;
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
