package com.springframeworkguru.webapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.springframeworkguru.webapp.data.JmsDataSource;
import com.springframeworkguru.webapp.data.MyDataSource;

@Configuration
@PropertySource(value = {"classpath:datasource.properties", "classpath:jms.properties"})
public class Property1Configuration {

    @Value("${sfg.petclinic.user}")
    String user;
    
    @Value("${sfg.petclinic.password}")
    String password;
    
    @Value("${sfg.petclinic.url}")
    String url;
    
    @Value("${jms.sfg.petclinic.user}")
    String jmsUser;
    
    @Value("${jms.sfg.petclinic.password}")
    String jmsPassword;
    
    @Value("${jms.sfg.petclinic.url}")
    String jmsUrl;
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertyConfigurer;
    }
    
    @Bean
    public MyDataSource myDataSource() {
        MyDataSource myDataSource  = new MyDataSource();
        myDataSource.setUser(user);
        myDataSource.setPassword(password);
        myDataSource.setUrl(url);
        return myDataSource;
    }

    @Bean
    public JmsDataSource jmsDataSource() {
        JmsDataSource jmsDataSource  = new JmsDataSource();
        jmsDataSource.setUser(jmsUser);
        jmsDataSource.setPassword(jmsPassword);
        jmsDataSource.setUrl(jmsUrl);
        return jmsDataSource;
    }

}
