package com.example.projetoBack.Model;

import javax.xml.crypto.Data;
import java.util.List;

public class BookList {
    private String listName;
    private List<DataBooks> list;

    public BookList(String listName, List<DataBooks> list) {
        this.listName = listName;
        this.list = list;

    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<DataBooks> getList() {
        return list;
    }

    public void setList(List<DataBooks> list) {
        this.list = list;
    }
}

