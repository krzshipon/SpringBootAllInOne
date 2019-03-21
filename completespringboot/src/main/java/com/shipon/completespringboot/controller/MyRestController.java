package com.shipon.completespringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @RequestMapping("/hello")
    public String sayHi(){
        return "Hi";
    }
}
