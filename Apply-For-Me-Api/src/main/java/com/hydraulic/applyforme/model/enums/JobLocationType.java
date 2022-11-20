package com.hydraulic.applyforme.model.enums;

import lombok.Getter;

@Getter
public enum JobLocationType {

    REMOTE("Remote"),
    ONSITE("Onsite"),
    HYBRID("Hybrid");

    private final String value;

    JobLocationType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
