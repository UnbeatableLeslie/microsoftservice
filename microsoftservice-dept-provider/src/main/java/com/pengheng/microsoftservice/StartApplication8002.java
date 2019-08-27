package com.pengheng.microsoftservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.pengheng.microsoftservice.dao")
@EnableEurekaClient
public class StartApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication8002.class,args);
    }
}
