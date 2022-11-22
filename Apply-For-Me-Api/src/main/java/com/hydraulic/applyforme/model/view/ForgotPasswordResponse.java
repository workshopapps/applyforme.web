package com.hydraulic.applyforme.model.view;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordResponse {

    private String message = "Reset password token sent to your email";
}
