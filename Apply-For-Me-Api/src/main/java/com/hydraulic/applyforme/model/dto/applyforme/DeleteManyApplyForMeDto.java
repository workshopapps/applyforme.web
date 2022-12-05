package com.hydraulic.applyforme.model.dto.applyforme;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteManyApplyForMeDto {

    @NotEmpty
    private List<Long> ids;
}
