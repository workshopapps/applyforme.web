package com.hydraulic.applyforme.model.dto.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteManyRoleDto {

    @JsonProperty("ids")
    List<Long> ids;
}
