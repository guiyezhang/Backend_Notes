package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class UserConsumer02Application {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumer02Application.class,args);

    }
    @Bean
    @LoadBalanced //开启ribbon，开启负载均衡(ribbon方式的)
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
