package com.springframeworkguru.webapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springframeworkguru.webapp.data.H2DataSource;

@Configuration
public class Property2Configuration {

    @Value("${h2.sfg.petclinic.user}")
    String user;
    
    @Value("${h2.sfg.petclinic.password}")
    String password;
    
    @Value("${h2.sfg.petclinic.url}")
    String url;
    
    @Bean
    public H2DataSource h2DataSource() {
        H2DataSource h2DataSource = new H2DataSource();
        h2DataSource.setUser(user);
        h2DataSource.setPassword(password);
        h2DataSource.setUrl(url);
        return h2DataSource;
    }
}
