package com.hydraulic.applyforme.model.enums;

import lombok.Getter;

@Getter
public enum JobSeniority {

    TRAINEE("Trainee"),
    INTERN("Intern"),
    JUNIOR("Junior"),
    MID_LEVEL("Mid-Level"),
    SENIOR("Senior");

    private final String value;

    JobSeniority(String value) {
        this.value = value;
    }

}
