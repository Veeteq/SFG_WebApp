package com.springframeworkguru.webapp.di.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloServiceImpl implements HelloService {

    public static final String HELLO_WORLD = "Hello World with HelloServiceImpl!";

    @Override
    public String sayHello() {
        return HELLO_WORLD;
    }
}
