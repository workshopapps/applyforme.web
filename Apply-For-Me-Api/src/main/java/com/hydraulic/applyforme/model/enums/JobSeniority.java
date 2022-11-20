package com.hydraulic.applyforme.model.enums;

import lombok.Getter;

@Getter
public enum JobSeniority {

    TRAINEE("Trainee"),
    INTERN("Intern"),
    JUNIOR("Junior"),
    MID_LEVEL("Mid-Level"),
    SENIOR("Senior");

    private String value;

    JobSeniority(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

}
