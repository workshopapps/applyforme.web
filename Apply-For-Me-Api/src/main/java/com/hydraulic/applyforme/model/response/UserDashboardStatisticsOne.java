package com.hydraulic.applyforme.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDashboardStatisticsOne {

    @JsonProperty("total_number_of_profiles")
    private Long totalNumberOfProfiles;

    @JsonProperty("total_number_of_submissions")
    private Long totalNumberOfSubmissions;
}
