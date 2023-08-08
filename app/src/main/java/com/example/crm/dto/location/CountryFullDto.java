package com.example.crm.dto.location;

import com.example.crm.domain.location.Country;
import com.example.crm.dto.IDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

/**
 * DTO for {@link Country}
 */
public record CountryFullDto(int id,
                             String name,
                             Set<CityDto> cityDtos
) implements IDto {
}
