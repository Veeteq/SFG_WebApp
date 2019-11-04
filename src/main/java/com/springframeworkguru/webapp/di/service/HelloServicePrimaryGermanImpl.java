package com.springframeworkguru.webapp.di.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("de")
@Primary
public class HelloServicePrimaryGermanImpl implements HelloService {

    @Override
    public String sayHello() {
        return "Primärer Begrüßungsdienst!";
    }

}
