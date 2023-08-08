package com.example.crm.service.user.impl;

import com.example.crm.dao.user.UserRepository;
import com.example.crm.domain.user.User;
import com.example.crm.service.BaseService;
import com.example.crm.service.user.UserService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService<User, Integer> implements UserService {

    @Getter(AccessLevel.PROTECTED)
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

}
