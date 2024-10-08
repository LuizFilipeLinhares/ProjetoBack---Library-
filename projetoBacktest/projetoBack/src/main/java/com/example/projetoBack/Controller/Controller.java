package com.example.projetoBack.Controller;

import com.example.projetoBack.Model.BookAdd;
import com.example.projetoBack.Model.BookList;
import com.example.projetoBack.Services.BService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.SplittableRandom;

@RestController
public class Controller {
    @GetMapping("/sobre")
    @ResponseBody
    public HashMap<String, String> sobre() {
        HashMap<String, String> sobre = new HashMap<>();
        sobre.put("estudante", "Luiz Filipe Linhares");
        sobre.put("projeto", "busca de livros (Library)");
        sobre.put("satc_codigo", "202312217");
        return sobre;
    }

    @GetMapping("/{listName}")
    public BookList listView(@PathVariable String listName){
        return BService.listView(listName);}
}
    @PostMapping("/Bookadd")
    public String bookAdd(@ResponseBody BookAdd bookAdd){
        return BService.addBook(bookAdd.getBookName(), bookAdd.getListName());
}