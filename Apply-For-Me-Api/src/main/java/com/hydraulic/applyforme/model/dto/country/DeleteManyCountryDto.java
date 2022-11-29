package com.hydraulic.applyforme.model.dto.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteManyCountryDto {

    @JsonProperty("ids")
    List<Long> ids;
}
