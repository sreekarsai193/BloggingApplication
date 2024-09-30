package com.example.bloggingapplication.guest;

import java.time.LocalDate;

public class Article {

    private String title;
    private String date;
    private String content;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public Article(String title, String date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }
    public Article()
    {

    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
}
