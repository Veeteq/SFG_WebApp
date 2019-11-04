package com.springframeworkguru.webapp.di.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springframeworkguru.webapp.di.service.HelloService;

@Controller
public class HelloController {

    private HelloService helloService;
    
    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String sayHello() {
        return helloService.sayHello();
    }
}
