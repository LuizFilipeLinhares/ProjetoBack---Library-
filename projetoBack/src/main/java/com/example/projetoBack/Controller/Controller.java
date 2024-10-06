package com.example.projetoBack.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Controller {
    @GetMapping("/sobre")
    @ResponseBody
    public HashMap<String, String> sobre(){
        HashMap<String, String> sobre = new HashMap<>();
        sobre.put("projeto", "busca de livros");
        sobre.put("nome", "Luiz Filipe Linhares");
        sobre.put("codigo", "202312217");
        return sobre;
    }
}
