package com.demo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class WebRunner {
    public static void main(String[] args) {
        SpringApplication.run(WebRunner.class, args);
        System.out.println("\nwebrunner success\n");
    }
}
