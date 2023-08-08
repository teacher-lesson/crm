package com.example.crm.mapper.location;

import com.example.crm.core.ReferenceMapper;
import com.example.crm.domain.location.City;
import com.example.crm.dto.location.CityDto;
import com.example.crm.mapper.BaseMapper;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = ReferenceMapper.class)
public interface CityMapper extends BaseMapper<City, CityDto, Long> {
}
