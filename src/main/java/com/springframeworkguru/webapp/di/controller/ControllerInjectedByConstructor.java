package com.springframeworkguru.webapp.di.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.springframeworkguru.webapp.di.service.HelloService;

@Controller
public class ControllerInjectedByConstructor {

    private HelloService helloService;

    @Autowired
    public ControllerInjectedByConstructor(@Qualifier(value = "helloServiceByConstructorImpl") HelloService helloService) {
        this.helloService = helloService;
    }

    public String sayHello() {
        return helloService.sayHello();
    }
}
