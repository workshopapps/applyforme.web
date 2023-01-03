package com.hydraulic.applyforme.model.dto.payment.paystack;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePlanDto {

    @NotNull(message = "Plan name cannot be null")
    @JsonProperty("name")
    private String name;

    @NotNull(message = "Interval cannot be null")
    @JsonProperty("interval")
    private String interval;

    @NotNull(message = "Amount cannot be null")
    @JsonProperty("amount")
    @Digits(integer = 6, fraction = 2)
    private Integer amount;
}
