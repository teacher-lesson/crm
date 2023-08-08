package com.example.crm.dto.location;

import com.example.crm.domain.location.Country;
import com.example.crm.dto.IDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for {@link Country}
 */
public record CityDto(long id,
                      @NotNull(message = "name must input")
                      @NotBlank(message = "name not must blank")
                      String name,
                      @NotNull
                      @Min(1)
                      int countyId
) implements IDto {
}
