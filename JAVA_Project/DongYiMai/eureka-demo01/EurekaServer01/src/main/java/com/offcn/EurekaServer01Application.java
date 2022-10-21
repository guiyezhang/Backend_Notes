package com.offcn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //声明当前是治理中心
public class EurekaServer01Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer01Application.class,args);
    }
}
