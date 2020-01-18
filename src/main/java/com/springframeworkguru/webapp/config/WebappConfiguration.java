package com.springframeworkguru.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.springframeworkguru.webapp.di.repository.HelloRepository;
import com.springframeworkguru.webapp.di.service.HelloService;
import com.springframeworkguru.webapp.di.service.HelloServiceFactory;

@Configuration
public class WebappConfiguration {

    @Bean
    HelloServiceFactory helloServiceFactory(HelloRepository helloRepository) {
        return new HelloServiceFactory(helloRepository);
    }
    
    @Bean
    @Primary
    @Profile({"en","default"})
    HelloService helloServicePrimary(HelloServiceFactory helloServiceFactory) {
        return helloServiceFactory.createHelloService("en");
    }

    @Bean
    @Primary
    @Profile({"es"})
    HelloService helloServiceSpanish(HelloServiceFactory helloServiceFactory) {
        return helloServiceFactory.createHelloService("es");
    }

    @Bean
    @Primary
    @Profile({"de"})
    HelloService helloServiceGerman(HelloServiceFactory helloServiceFactory) {
        return helloServiceFactory.createHelloService("de");
    }
}
