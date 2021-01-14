package com.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaRunner {

    public static void main(String[] args){
        SpringApplication.run(EurekaRunner.class,args);
        System.out.println("启动Eureka");
    }

}
