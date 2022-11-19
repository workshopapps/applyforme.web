package com.hydraulic.applyforme.model.dto.country;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteManyCountryDto {

    List<Long> ids;
}
