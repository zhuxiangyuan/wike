package com.javaa.wike.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.javaa")
public class WikeApplication {


    public static void main(String[] args) {
        SpringApplication.run(WikeApplication.class, args);
    }

}
