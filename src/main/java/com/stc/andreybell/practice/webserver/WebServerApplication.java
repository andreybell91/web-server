package com.stc.andreybell.practice.webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebServerApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(WebServerApplication.class, args);
        AppServer appServer = context.getBean(AppServer.class);
        appServer.run();
    }

}
