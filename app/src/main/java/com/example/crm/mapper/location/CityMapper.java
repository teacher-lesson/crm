package com.example.crm.mapper.location;

import com.example.crm.dao.location.CityRepository;
import com.example.crm.domain.location.City;
import com.example.crm.dto.location.CityDto;
import com.example.crm.mapper.BaseMapper;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = CityRepository.class)
public interface CityMapper extends BaseMapper<City, CityDto, Long> {
}
