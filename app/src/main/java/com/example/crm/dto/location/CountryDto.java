package com.example.crm.dto.location;

import com.example.crm.domain.location.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for {@link Country}
 */
public record CountryDto(int id,
                         @NotNull(message = "name must input")
                         @NotBlank(message = "name not must blank")
                         String name
) implements com.example.crm.dto.IDto {
}
