package com.example.ProjetoLib.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataBooks {
    @JsonProperty("title")
    private String title;

    @JsonProperty("author_name")
    private String[] author;

    @JsonProperty("first_publish_year")
    private int publishYear;

    public DataBooks(String title, String[] author, int publishYear) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthor() {
        return author;
    }

    public void setAuthor(String[] author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
}

