package com.springframeworkguru.webapp.di.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.springframeworkguru.webapp.di.service.HelloService;

@Controller
public class ControllerInjectedBySetter {

    private HelloService helloService;
    
    public String sayHello() {
        return helloService.sayHello();
    }

    @Autowired
    public void setHelloService(@Qualifier(value = "helloServiceByGetterImpl") HelloService helloService) {
        this.helloService = helloService;
    }
}
