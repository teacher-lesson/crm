package com.example.crm.service.location.impl;

import com.example.crm.dao.location.CountryRepository;
import com.example.crm.domain.location.Country;
import com.example.crm.service.BaseService;
import com.example.crm.service.location.CountryService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends BaseService<Country, Integer> implements CountryService {

    @Getter(AccessLevel.PROTECTED)
    private CountryRepository repository;

    @Autowired
    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Country readByName(String name) {
        return repository.findByName(name);
    }
}
