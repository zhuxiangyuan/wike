package com.javaa.wike.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hello")
    public Object hello(){
        return "hello";
    }

    @RequestMapping("/hello/post")
    public Object helloPost(String name){
        return "hello"+name;
    }
}
