package com.hydraulic.applyforme.model.dto.role;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteManyRoleDto {

    List<Long> ids;
}
