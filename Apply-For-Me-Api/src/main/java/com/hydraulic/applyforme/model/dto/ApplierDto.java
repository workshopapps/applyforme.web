package com.hydraulic.applyforme.model.dto;

import com.hydraulic.applyforme.model.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApplierDto {
    private Long id;
    private Member member;
}
