package com.springframeworkguru.webapp.di;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.springframeworkguru.webapp.di.controller.ControllerInjectedByProperty;
import com.springframeworkguru.webapp.di.service.HelloServiceImpl;

public class ControllerInjectedByPropertyTest {

    private ControllerInjectedByProperty controller;
    
    @Before
    public void setUp() {
        this.controller = new ControllerInjectedByProperty();
        this.controller.helloService = new HelloServiceImpl();
    }
    
    @Test
    public void testHello() {
        assertEquals(HelloServiceImpl.HELLO_WORLD, controller.sayHello());
    }
}
