package com.hydraulic.applyforme.model.dto.applyforme;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ApplyForMeDto {

    @NotNull(message = "applyforMe.title.notNull")
    private String title;

    @JsonProperty("description_of_app")
    private String descriptionOfApp;
}
