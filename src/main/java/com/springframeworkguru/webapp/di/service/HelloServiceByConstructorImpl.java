package com.springframeworkguru.webapp.di.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceByConstructorImpl implements HelloService {

    public static final String HELLO_WORLD = "Hello World with Getter!";

    @Override
    public String sayHello() {
        return HELLO_WORLD;
    }
}
