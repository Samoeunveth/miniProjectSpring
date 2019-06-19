package com.example.demohomework.repository.articleRepository.model;

import java.util.Locale;

public class Article {
    private int id;
    private String title;
    private String auther;
    private Category category;
    private String description;
    private String thumbnail;


    public Article(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", auther='" + auther + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }

    public Article(int id, String title, String auther, int c_id, String description, String thumbnail) {
        this.id = id;
        this.title = title;
        this.auther = auther;
        this.category.setId(c_id);
        this.description = description;
        this.thumbnail = thumbnail;
    }
}
