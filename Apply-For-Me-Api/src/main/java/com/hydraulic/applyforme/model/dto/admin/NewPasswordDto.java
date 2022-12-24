package com.hydraulic.applyforme.model.dto.admin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewPasswordDto {


    @NotNull(message = "{member.password.notNull}")
    @Size(min = 8, message = "{member.password.size}")
    @JsonProperty("new_password")
    private String newPassword;

    @NotNull(message = "{member.password.notNull}")
    @Size(min = 8, message = "{member.password.size}")
    @JsonProperty("confirmation_password")
    private String confirmationPassword;
}
