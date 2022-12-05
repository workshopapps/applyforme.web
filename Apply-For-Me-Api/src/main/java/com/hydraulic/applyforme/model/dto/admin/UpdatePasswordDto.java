package com.hydraulic.applyforme.model.dto.admin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hydraulic.applyforme.annotation.EqualPassword;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePasswordDto {

	@NotNull(message = "{superAdmin.password.notNull}")
	@Size(min = 8, message = "{superAdmin.password.size}")
	@JsonProperty("existing_password")
	private String existingPassword;

	@NotNull(message = "{superAdmin.password.notNull}")
	@Size(min = 8, message = "{superAdmin.password.size}")
	@JsonProperty("new_password")
	private String newPassword;

	@NotNull(message = "{superAdmin.password.notNull}")
	@Size(min = 8, message = "{superAdmin.password.size}")
	@JsonProperty("confirmation_password")
	private String confirmationPassword;
}
