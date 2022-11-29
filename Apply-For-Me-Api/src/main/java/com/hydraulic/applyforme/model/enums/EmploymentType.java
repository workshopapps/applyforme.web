package com.hydraulic.applyforme.model.enums;

import lombok.Getter;

@Getter
public enum EmploymentType {

    FULL_TIME("Full Time"),
    PART_TIME("Part Time"),
    CONTRACT("Contract");

    private final String value;

    EmploymentType(String value) {
        this.value = value;
    }

}
