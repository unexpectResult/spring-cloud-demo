package com.demo.commons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonsRunner {

    public static void main(String[] args){
        SpringApplication.run(CommonsRunner.class,args);
        System.out.println("\ncommonsServer success\n");
    }

}
