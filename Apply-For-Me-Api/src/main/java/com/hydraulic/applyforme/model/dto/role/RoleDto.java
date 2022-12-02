package com.hydraulic.applyforme.model.dto.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RoleDto {

    @NotNull(message = "{role.title.notNull}")
    @Size(min = 1, max = 200, message = "{role.title.size}")
    @JsonProperty("title")
    private String title;

    @NotNull(message = "{role.code.notNull}")
    @Size(min = 1, max = 200, message = "{role.code.size}")
    @JsonProperty("code")
    private String code;
}
