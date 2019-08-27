package com.pengheng.microsoftservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StartApplication7001 {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication7001.class,args);
    }
}
