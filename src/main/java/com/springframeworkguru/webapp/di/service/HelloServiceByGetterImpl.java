package com.springframeworkguru.webapp.di.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceByGetterImpl implements HelloService {

    public static final String HELLO_WORLD = "Hello World with HelloServiceByGetterImpl!";

    @Override
    public String sayHello() {
        return HELLO_WORLD;
    }
}
