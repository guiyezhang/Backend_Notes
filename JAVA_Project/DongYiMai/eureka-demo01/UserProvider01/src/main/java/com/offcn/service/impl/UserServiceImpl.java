package com.offcn.service.impl;

import com.offcn.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getString() {
        return "user...service...01";
    }
}
