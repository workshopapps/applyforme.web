package com.hydraulic.applyforme.model.dto.secretCode;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MemberSecretCodeDto {
    @NotNull(message = "{memberSecretCode.firstCode.notNull}")
    @Size(min = 1, max = 1, message = "{memberSecretCode.firstCode.size}")
    private  String firstCode;

    @NotNull(message = "{memberSecretCode.secondCode.notNull}")
    @Size(min = 1, max = 1, message = "{memberSecretCode.secondCode.size}")
    private  String secondCode;

    @NotNull(message = "{memberSecretCode.thirdCode.notNull}")
    @Size(min = 1, max = 1, message = "{memberSecretCode.thirdCode.size}")
    private  String thirdCode;

    @NotNull(message = "{memberSecretCode.thirdCode.notNull}")
    @Size(min = 1, max = 1, message = "{memberSecretCode.fourthCode.size}")
    private  String fourthCode;
}
