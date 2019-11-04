package com.springframeworkguru.webapp.di.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile({"en","default"})
public class HelloServicePrimaryImpl implements HelloService {

    @Override
    public String sayHello() {
        return "Hello from Primary!";
    }

}
