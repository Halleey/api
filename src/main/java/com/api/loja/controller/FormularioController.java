package com.api.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "api/public")
public class FormularioController {

    @GetMapping("/")
    public  String home() {
        return  "home";
    }
    
    @GetMapping("/formulario")
    public String formulario() {
        return "formulario";
    }

    @GetMapping("membros")
    public  String membros() {
        return "membros";
    }
    @GetMapping("/insertProduct")
    public  String produto() {
        return  "produto";
    }

    @GetMapping("/login")
    public  String login() {
        return  "login";
    }
    @GetMapping("main")
    public String Main() {
        return "main";
    }
}
