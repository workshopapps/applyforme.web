package com.hydraulic.applyforme.model.enums;

import lombok.Getter;

@Getter
public enum RoleType {

    SUPER_ADMINISTRATOR("SuperAdministrator"),
    ADMINISTRATOR("Administrator"),
    RECRUITER("Recruiter"),
    PROFESSIONAL("Professional");

    private final String value;

    RoleType(String value) {
        this.value = value;
    }
}
