package com.example.projetoBack.Model;

public class BookAdd {
    private String bookName;
    private String listName;

    public BookAdd(String bookName, String listName) {
        this.bookName = bookName;
        this.listName = listName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
