package com.offcn.service.impl;

import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    //远程调用功能对象
    @Autowired
    private RestTemplate restTemplate;
    //获取提供方信息的对象-- 实现负载均衡
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //实现负载均衡
    private String getUrl(){
        ServiceInstance userprovider = loadBalancerClient.choose("USERPROVIDER");
        String host = userprovider.getHost();
        int port = userprovider.getPort();
        return "http://" + host  + ":" + port;//http://localhost:xxx
    }

    @Override
    public String getString() {
        //远程调用
        ResponseEntity<String> forEntity = restTemplate.getForEntity(getUrl() + "/user", String.class);//基于http方式进行远程调用
        String body = forEntity.getBody();
        return body;

    }
}
