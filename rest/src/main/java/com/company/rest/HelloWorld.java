package com.company.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

//    @RequestMapping("/")
    @GetMapping("/")
    public String index(){
        return "Hello World";
    }
}
