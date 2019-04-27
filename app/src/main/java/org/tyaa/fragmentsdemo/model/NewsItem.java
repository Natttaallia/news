package org.tyaa.fragmentsdemo.model;

import java.util.Date;

public class NewsItem {

    //TODO Lombok
    private Integer id;
    private String title;
    private String content;
    private String author;
    private String date;
    private String tag;
    private String category;

    public NewsItem(Integer id, String title, String content, String author, String date, String tag, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author=author;
        this.category=category;
        this.date=date;
        this.tag=tag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
