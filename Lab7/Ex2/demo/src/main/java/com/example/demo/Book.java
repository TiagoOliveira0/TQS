package com.example.demo;

import java.time.LocalDateTime;
import java.util.Date;

public class Book {
    private String title;
    private String author;
    private LocalDateTime published;

    public Book(String title, String author, LocalDateTime published) {
        this.title = title;
        this.author = author;
        this.published = published;
    }

    public Book() {

    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getPublished() {
        return published;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublished(LocalDateTime published) {
        this.published = published;
    }
}