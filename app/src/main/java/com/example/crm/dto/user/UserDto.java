package com.example.crm.dto.user;

import com.example.crm.dto.IEntityDto;

/**
 * DTO for {@link com.example.crm.domain.user.User}
 */
public record UserDto(Integer id,
                      String firstName,
                      String lastName,
                      String username,
                      String password,
                      Long locationId) implements IEntityDto<Integer> {
}