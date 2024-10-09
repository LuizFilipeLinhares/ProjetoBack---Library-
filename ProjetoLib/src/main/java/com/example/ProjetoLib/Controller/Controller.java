package com.example.ProjetoLib.Controller;

import com.example.ProjetoLib.Model.BookAdd;
import com.example.ProjetoLib.Model.BookList;
import com.example.ProjetoLib.Service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class Controller {
    @Autowired
    private BService bService;

    @GetMapping("/sobre")
    public HashMap<String, String> sobre() {
        HashMap<String, String> sobre = new HashMap<>();
        sobre.put("estudante", "Luiz Filipe Linhares");
        sobre.put("projeto", "busca de livros (Library)");
        sobre.put("satc_codigo", "202312217");
        return sobre;
    }

    @GetMapping("/{listName}")
    public BookList listView(@PathVariable String listName) {
        return bService.listView(listName);
    }

    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody BookAdd bookAdd) {
        String result = bService.addBook(bookAdd.getBookName(), bookAdd.getListName());
        return ResponseEntity.ok(result);
    }
}