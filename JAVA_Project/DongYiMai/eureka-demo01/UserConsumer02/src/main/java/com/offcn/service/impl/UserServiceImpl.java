package com.offcn.service.impl;

import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getString() {
        //远程调用
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://USERPROVIDER/user", String.class);//基于http方式进行远程调用
        String body = forEntity.getBody();
        return body;

    }
}
