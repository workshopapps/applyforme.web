package com.hydraulic.applyforme.service;


import com.hydraulic.applyforme.model.dto.secretCode.MemberSecretCodeDto;

public interface MemberSecretCodeService {
    public String matchVerificationCodes(MemberSecretCodeDto memberSecretCodeDto);
    public String createResetPasswordCode();

}
