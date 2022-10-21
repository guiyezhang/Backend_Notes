package com.offcn.service.impl;

import com.offcn.service.HelloService;
import org.springframework.stereotype.Service;

//对象创建
@Service
public class HelloServiceImpl implements HelloService {

    //服务提供者对外提供的功能--资源
    @Override
    public String getString() {
        return "此方法代表对外提供的资源,方法返回什么表示对外提供什么.";
    }
}
