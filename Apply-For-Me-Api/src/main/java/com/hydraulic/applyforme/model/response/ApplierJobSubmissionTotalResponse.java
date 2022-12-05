package com.hydraulic.applyforme.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplierJobSubmissionTotalResponse {

    @JsonProperty("applier_id")
    private Long applierId;

    @JsonProperty("total_submission")
    private Long total;
}
