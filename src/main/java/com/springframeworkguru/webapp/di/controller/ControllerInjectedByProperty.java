package com.springframeworkguru.webapp.di.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.springframeworkguru.webapp.di.service.HelloService;

@Controller
public class ControllerInjectedByProperty {

    @Autowired
    @Qualifier("helloServiceImpl")
    public HelloService helloService;
    
    public String sayHello() {
        return helloService.sayHello();
    }

    public HelloService getHelloService() {
        return helloService;
    }
}
