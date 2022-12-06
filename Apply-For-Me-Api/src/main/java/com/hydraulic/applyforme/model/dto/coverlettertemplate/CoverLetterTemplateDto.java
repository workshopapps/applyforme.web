package com.hydraulic.applyforme.model.dto.coverlettertemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CoverLetterTemplateDto {

    @NotNull(message = "{coverLetterTemplate.title.notNull}")
    @Size(min = 1, max = 300, message = "{coverLetterTemplate.title.size}")
    @JsonProperty("title")
    private String title;

    @NotNull(message = "{coverLetterTemplate.content.notNull}")
    @Size(min = 1, max = 5000, message = "{coverLetterTemplate.content.size}")
    @JsonProperty("content")
    private String content;
}
