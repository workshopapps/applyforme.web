package com.hydraulic.applyforme.model.dto.professional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteManyProfessionalDto {

    @JsonProperty("ids")
    private List<Long> ids;
}
