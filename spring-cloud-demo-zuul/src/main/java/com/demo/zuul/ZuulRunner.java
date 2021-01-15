package com.demo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulRunner {

    public  static void main(String [] args){
        SpringApplication.run(ZuulRunner.class,args);
        System.out.println("\nZuulRunner Success\n");
    }

}
