package com.xkc.spring.controller;

import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class TestController {

    @PostConstruct
    public void f() {
        System.out.println("创建testController");
    }

}
