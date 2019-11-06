package com.springframeworkguru.webapp.di.service;

import com.springframeworkguru.webapp.di.repository.HelloRepository;

public class HelloServicePrimaryImpl implements HelloService {

    private HelloRepository helloRepository;
    
    public HelloServicePrimaryImpl(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Override
    public String sayHello() {
        return helloRepository.getEnglishGreeting();
    }
}
