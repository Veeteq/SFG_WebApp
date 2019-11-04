package com.springframeworkguru.webapp.di.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("es")
@Primary
public class HelloServicePrimarySpanishImpl implements HelloService {

    @Override
    public String sayHello() {
        return "Servicio di Salodo Primario!";
    }

}
