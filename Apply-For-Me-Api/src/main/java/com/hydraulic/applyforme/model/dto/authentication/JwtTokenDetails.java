package com.hydraulic.applyforme.model.dto.authentication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class JwtTokenDetails {

    private String sub;

    private String[] roles;

    private Object memberId;

    private String memberType;

}
