package com.springframeworkguru.webapp.di.service;

import com.springframeworkguru.webapp.di.repository.HelloRepository;

public class HelloServicePrimaryGermanImpl implements HelloService {

    private HelloRepository helloRepository;
    
    public HelloServicePrimaryGermanImpl(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Override
    public String sayHello() {
        return helloRepository.getGermanGreeting();
    }
}
