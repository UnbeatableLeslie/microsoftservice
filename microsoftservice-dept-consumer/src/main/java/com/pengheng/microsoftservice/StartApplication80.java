package com.pengheng.microsoftservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class StartApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication80.class,args);
    }

    @Bean
    //负载均衡请求
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
