package com.example.projetoBack.Services;

import com.example.projetoBack.Model.Book;
import com.example.projetoBack.Model.BookList;
import com.example.projetoBack.Model.DataBooks;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {
    private HashMap<String, DataBooks> dataBooks = new HashMap<>();
    private String URL = "https://openlibrary.org/search.json?q=";
    private RestTemplate restTemplate = new RestTemplate();

    public Book findBook(String bookName) throws IOException, InterruptedException {
        String encodedBookName = URLEncoder.encode(bookName, StandardCharsets.UTF_8);
        String url = URL + encodedBookName;
        Book book = restTemplate.getForObject(url, Book.class);
        try {
            if (book != null && book.getDocs() != null && book.getDocs().length > 0) {
                return book;
            } else {
                throw new Exception("Infelizmente seu livro não foi encontrado :( : " + bookName);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public String addBook (String bookName, String listName) throws IOException, InterruptedException {
        Book book = findBook(bookName);
        BookList list = dataBooks.getOrDefault(listName, new BookList(listName, new ArrayList<>()));
        list.getList().add(book.getDocs()[0]);
        dataBooks.put(listName, list);
        return "parabens! Você adiciionou o livro: "  book.getDocs()[0].getTitle();

    }
    public DataBooks listView(String listName){
        return dataBooks.get(listName);
    }

}