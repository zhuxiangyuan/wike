package com.javaa.wike.controller;

import com.javaa.wike.domain.Test;
import com.javaa.wike.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/hello")
    public Object hello(){
        return "hello";
    }

    @RequestMapping("/hello/post")
    public Object helloPost(String name){
        return "hello"+name;
    }

    @RequestMapping("/list")
    public List<Test> list(){
        return testService.list();
    }
}
