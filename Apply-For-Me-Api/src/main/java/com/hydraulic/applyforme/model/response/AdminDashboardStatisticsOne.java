package com.hydraulic.applyforme.model.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminDashboardStatisticsOne {

    @JsonProperty("total_users")
    private Long totalUsers;

    @JsonProperty("total_applications")
    private Long totalApplications;
}
