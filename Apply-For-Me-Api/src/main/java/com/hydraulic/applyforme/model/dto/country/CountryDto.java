package com.hydraulic.applyforme.model.dto.country;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CountryDto {

    @NotNull(message = "{country.title.notNull}")
    @Size(min = 1, max = 300, message = "{country.title.size}")
    private String title;

    @NotNull(message = "{country.abbreviation.notNull}")
    @Size(min = 3, max = 10, message = "{country.abbreviation.size}")
    private String abbreviation;
}
