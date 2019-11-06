package com.springframeworkguru.webapp.di.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryImpl implements HelloRepository {

    @Override
    public String getEnglishGreeting() {
        return "Hello from Primary!";
    }

    @Override
    public String getSpanishGreeting() {
        return "Servicio di Salodo Primario!";
    }

    @Override
    public String getGermanGreeting() {
        return "Primärer Begrüßungsdienst!";
    }

}
