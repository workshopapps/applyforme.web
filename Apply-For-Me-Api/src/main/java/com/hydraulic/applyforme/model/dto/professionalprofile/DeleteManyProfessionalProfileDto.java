package com.hydraulic.applyforme.model.dto.professionalprofile;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteManyProfessionalProfileDto {

    @JsonProperty("ids")
    List<Long> ids;
}
