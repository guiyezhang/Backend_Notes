package com.offcn.service.impl;

import com.offcn.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {



    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient  discoveryClient; //获取http组成


    private String getUrl(){
        List<ServiceInstance> instances = discoveryClient.getInstances("HELLOPROVIDER01");//服务提供方的端口、域名等
        if (instances != null && instances.size() > 0){
            ServiceInstance serviceInstance = instances.get(0);
            String host = serviceInstance.getHost(); //localhost
            int port = serviceInstance.getPort(); //9001
            return "http://" + host + ":" + port;
        }
        return null;
    }
    //表面是重写方法,但是内部实际是远程调用服务提供者的提供的功能
    @Override
    public String getString() {

        ResponseEntity<String> forEntity = restTemplate.getForEntity(getUrl() + "/hello", String.class);//基于http方式进行远程调用
        String body = forEntity.getBody();
        return body;
    }
}
