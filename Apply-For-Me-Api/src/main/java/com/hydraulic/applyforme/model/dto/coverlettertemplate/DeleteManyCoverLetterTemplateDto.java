package com.hydraulic.applyforme.model.dto.coverlettertemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteManyCoverLetterTemplateDto {

    @JsonProperty("ids")
    List<Long> ids;
}
