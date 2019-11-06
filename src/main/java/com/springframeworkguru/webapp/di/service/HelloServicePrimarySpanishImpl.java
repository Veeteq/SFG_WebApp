package com.springframeworkguru.webapp.di.service;

import com.springframeworkguru.webapp.di.repository.HelloRepository;

public class HelloServicePrimarySpanishImpl implements HelloService {

    private HelloRepository helloRepository;
    
    public HelloServicePrimarySpanishImpl(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Override
    public String sayHello() {
        return helloRepository.getSpanishGreeting();
    }

}
