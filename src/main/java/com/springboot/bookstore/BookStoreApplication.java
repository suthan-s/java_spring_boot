package com.springboot.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class,args);  //here the run method getting two parameter one is source, next one is args.
        //source- which class we need to run, args- we are getting main method args that we need to pass.

    }
}
