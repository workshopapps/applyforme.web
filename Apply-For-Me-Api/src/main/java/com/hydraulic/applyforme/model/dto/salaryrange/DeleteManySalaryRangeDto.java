package com.hydraulic.applyforme.model.dto.salaryrange;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteManySalaryRangeDto {

    @JsonProperty("ids")
    List<Long> ids;
}
