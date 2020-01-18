package com.springframeworkguru.webapp.di.service;

import com.springframeworkguru.webapp.di.repository.HelloRepository;

public class HelloServiceFactory {
    
    private HelloRepository helloRepository;

    public HelloServiceFactory(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }
    
    public HelloService createHelloService(String lang) {
        switch(lang) {
        case "en":
            return new HelloServicePrimaryImpl(helloRepository);
        case "es":
            return new HelloServicePrimarySpanishImpl(helloRepository);
        case "de":
            return new HelloServicePrimaryGermanImpl(helloRepository);
        default:
            return new HelloServicePrimaryImpl(helloRepository);
        }
    }
}
