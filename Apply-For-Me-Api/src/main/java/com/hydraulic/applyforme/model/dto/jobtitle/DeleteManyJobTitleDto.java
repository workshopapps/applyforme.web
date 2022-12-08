package com.hydraulic.applyforme.model.dto.jobtitle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteManyJobTitleDto {

    @JsonProperty("ids")
    List<Long> ids;
}
