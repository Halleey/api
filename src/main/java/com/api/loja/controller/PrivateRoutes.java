package com.api.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "api/private")
public class PrivateRoutes {

    @GetMapping("/insertProduct")
    public  String produto() {
        return  "produto";
    }
}
