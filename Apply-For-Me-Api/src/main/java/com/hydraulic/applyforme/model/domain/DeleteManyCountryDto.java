package com.hydraulic.applyforme.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteManyCountryDto {

    List<Long> ids;
}
