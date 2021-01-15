package com.demo.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DaoRunner {

    public static void main(String[] args){
        SpringApplication.run(DaoRunner.class,args);
        System.out.println("\ndaoServer success\n");
    }

}
