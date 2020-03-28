package com.example.springbootmysql;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {

    @RequestMapping("/hello")
    public String getHello() {
        return "Hello";
    }
}
