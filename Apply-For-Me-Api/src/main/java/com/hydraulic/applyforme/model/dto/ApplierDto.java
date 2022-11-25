package com.hydraulic.applyforme.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.model.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApplierDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("member")
    private Member member;
}
