package com.example.crm.service.location.impl;

import com.example.crm.dao.location.CityRepository;
import com.example.crm.domain.location.City;
import com.example.crm.service.BaseService;
import com.example.crm.service.location.CityService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends BaseService<City, Long> implements CityService {

    @Getter(AccessLevel.PROTECTED)
    private CityRepository repository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }
}
