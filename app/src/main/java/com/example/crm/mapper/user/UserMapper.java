package com.example.crm.mapper.user;

import com.example.crm.domain.user.User;
import com.example.crm.dto.user.UserDto;
import com.example.crm.mapper.BaseMapper;
import com.example.crm.mapper.location.CityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = CityMapper.class)
public interface UserMapper extends BaseMapper<User, UserDto, Integer> {

    @Mapping(source = "location.id", target = "locationId")
    UserDto toDto(User entity);

    @Mapping(source = "locationId", target = "location")
    User toEntity(UserDto dto);
}
