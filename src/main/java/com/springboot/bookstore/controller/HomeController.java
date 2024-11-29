package com.springboot.bookstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home") //directly we can use Requestmapping here and if we want we can use on method also
public class HomeController {

    //now we can learn how to call get api
    //@RequestMapping(value = "/start",method = RequestMethod.GET)
    //@RequestMapping("/start") //this is also same we don't need to give explicitly
    @GetMapping("/start") //we can use Getmapping also
    public String start(){
        return "Hello welcome to Spring boot learning: ";
    }
    @GetMapping("/end")
    public String end(){
        return "hope you continue to learn: ";
    }
}
