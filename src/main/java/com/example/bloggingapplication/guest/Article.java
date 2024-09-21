package com.example.bloggingapplication.guest;

import java.time.LocalDate;

public class Article {

    private String title;
    private LocalDate date;
    private String content;

    public Article(String title, LocalDate date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
}
