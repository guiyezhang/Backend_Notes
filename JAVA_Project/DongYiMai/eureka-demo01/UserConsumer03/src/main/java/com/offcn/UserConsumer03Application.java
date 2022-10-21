package com.offcn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //表示运行当前项目作为eureka的客户端
@EnableFeignClients //表示开启feign远程传输方式
public class UserConsumer03Application {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumer03Application.class,args);
    }


    //
}
