package com.javaa.wike.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.javaa")
@MapperScan("com.javaa.wike.mapper")
public class WikeApplication {


    public static void main(String[] args) {
        SpringApplication.run(WikeApplication.class, args);
    }

}
