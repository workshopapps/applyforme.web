package com.hydraulic.applyforme.model.dto.professional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.model.domain.Submission;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ProfessionalDto {

    @JsonProperty("availableForInterview")
    private boolean availableForInterview = false;

    @JsonProperty("linkedinLink")
    private String linkedinLink;

    @JsonProperty("facebookLink")
    private String facebookLink;

    @JsonProperty("twitterLink")
    private String twitterLink;

    @JsonProperty("instagramLink")
    private String instagramLink;

    @JsonProperty("hobbies")
    private String hobbies;

    @JsonProperty("otherLink1")
    private String otherLink1;

    @JsonProperty("otherLink2")
    private String otherLink2;

    @JsonProperty("otherLink3")
    private String otherLink3;
}
