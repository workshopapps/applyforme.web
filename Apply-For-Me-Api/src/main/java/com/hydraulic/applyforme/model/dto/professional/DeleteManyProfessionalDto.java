package com.hydraulic.applyforme.model.dto.professional;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteManyProfessionalDto {

    private List<Long> ids;
}
