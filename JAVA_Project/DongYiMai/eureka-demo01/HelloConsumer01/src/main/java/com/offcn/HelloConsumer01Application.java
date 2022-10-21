package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloConsumer01Application {
    public static void main(String[] args) {
        SpringApplication.run(HelloConsumer01Application.class,args); }

        //实现远程调用功能的对象
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
