package com.example.crm.dto.location;

import com.example.crm.domain.location.Country;
import com.example.crm.dto.IDto;
import com.example.crm.dto.IEntityDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for {@link Country}
 */
public record CityDto(Long id,
                      @NotNull(message = "name must input")
                      @NotBlank(message = "name not must blank")
                      String name,
                      @NotNull
                      @Min(1)
                      int countyId
) implements IEntityDto<Long> {
}
