package com.hydraulic.applyforme.model.dto.salaryrange;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SalaryRangeDto {

    @NotNull(message = "{salaryRange.salaryRange.notNull}")
    @Size(min = 1, max = 300, message = "{salaryRange.salaryRange.size}")
    private String salaryRange;

}