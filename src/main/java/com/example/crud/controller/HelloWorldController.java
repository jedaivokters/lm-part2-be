package com.example.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWorldController
{
    @RequestMapping("/world")
    public String hello()
    {
        return "Hello World~ TEST";
    }
}
