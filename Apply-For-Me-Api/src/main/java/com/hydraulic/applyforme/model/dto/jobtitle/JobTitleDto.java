package com.hydraulic.applyforme.model.dto.jobtitle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class JobTitleDto {

    @NotNull(message = "{jobTitle.title.notNull}")
    @Size(min = 1, max = 300, message = "{jobTitle.title.size}")
    @JsonProperty("title")
    private String title;
}
