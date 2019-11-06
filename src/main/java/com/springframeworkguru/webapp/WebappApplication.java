package com.springframeworkguru.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springframeworkguru.webapp.data.H2DataSource;
import com.springframeworkguru.webapp.data.JmsDataSource;
import com.springframeworkguru.webapp.data.MyDataSource;
import com.springframeworkguru.webapp.di.controller.ControllerInjectedByConstructor;
import com.springframeworkguru.webapp.di.controller.ControllerInjectedByProperty;
import com.springframeworkguru.webapp.di.controller.ControllerInjectedBySetter;
import com.springframeworkguru.webapp.di.controller.HelloController;

@SpringBootApplication
public class WebappApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(WebappApplication.class, args);
		
		HelloController helloController = ctx.getBean(HelloController.class);
		
		System.out.println(helloController.sayHello());
		System.out.println(ctx.getBean(ControllerInjectedByProperty.class).sayHello());
		System.out.println(ctx.getBean(ControllerInjectedBySetter.class).sayHello());
		System.out.println(ctx.getBean(ControllerInjectedByConstructor.class).sayHello());
		
		MyDataSource myDataSource = ctx.getBean(MyDataSource.class);
		System.out.println(myDataSource);
		
		JmsDataSource jmsDataSource = ctx.getBean(JmsDataSource.class);
        System.out.println(jmsDataSource);
        
        H2DataSource h2DataSource = ctx.getBean(H2DataSource.class);
        System.out.println(h2DataSource);
	}
}

