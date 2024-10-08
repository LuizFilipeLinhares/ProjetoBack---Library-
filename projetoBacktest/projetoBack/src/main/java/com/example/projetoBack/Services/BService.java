package com.example.projetoBack.Services;

import com.example.projetoBack.Model.Book;
import com.example.projetoBack.Model.BookList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class BService {
    private Map<String, BookList> bookList = new HashMap<>();
    private final String API_URL = "https://openlibrary.org/search.json?q=";

    public Book findBookAPI(String bookName) throws IOException, InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        String encodedBookName = URLEncoder.encode(bookName, StandardCharsets.UTF_8);
        String url = API_URL + encodedBookName;
        Book book = restTemplate.getForObject(url, Book.class);
        if (book != null && book.getDocs() != null && book.getDocs().length > 0) {
            return book;
        } else {
            System.out.println("Infelizmente seu livro não foi encontrado :( : " + bookName);
            return null;
        }
    }

    public String addBook(String bookName, String listName) throws IOException, InterruptedException {
        Book book = findBookAPI(bookName);
        BookList list = bookList.getOrDefault(listName, new BookList(listName, new ArrayList<>()));
        list.getList().add(book.getDocs()[0]);
        bookList.put(listName, list);

        return "Parabéns! Você adicionou o livro: " + book.getDocs()[0].getTitle();
    }

    public BookList listView(String listName) {
        return bookList.get(listName);
    }
}

