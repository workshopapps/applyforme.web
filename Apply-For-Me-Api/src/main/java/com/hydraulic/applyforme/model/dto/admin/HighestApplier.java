package com.hydraulic.applyforme.model.dto.admin;

import com.hydraulic.applyforme.model.domain.Member;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class HighestApplier {

    private Long id;
    private Member member;
}


