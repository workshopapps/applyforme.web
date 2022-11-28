package com.hydraulic.applyforme.model.dto;

import lombok.Data;

@Data
public class UpdatePasswordDTO {

	private String initialPassword;
	private String newPassword;
}
