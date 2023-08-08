package com.example.crm.service.location;

import com.example.crm.domain.location.Country;
import com.example.crm.service.IService;

public interface CountryService extends IService<Country, Integer> {
    Country readByName(String name);
}
