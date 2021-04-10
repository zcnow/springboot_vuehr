package com.lazyc.vuehr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/employee/basic/hello")
    public String basicHello() {
        return "basic hello";
    }

    @GetMapping("/employee/advanced/hello")
    public String advancedHello() {
        return "advanced hello";
    }
}
