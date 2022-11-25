package com.hydraulic.applyforme.model.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.model.domain.Applier;
import com.hydraulic.applyforme.model.domain.Member;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplierJobSubmissionStatistics {

    private Applier applier;

    @JsonProperty("applier_id")
    private Long applierId;

    @JsonProperty("total_submission")
    private Long total;
}
