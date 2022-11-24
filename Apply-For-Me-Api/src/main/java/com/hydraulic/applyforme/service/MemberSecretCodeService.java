package com.hydraulic.applyforme.service;


import com.hydraulic.applyforme.model.dto.secretCode.MemberSecretCodeDto;

public interface MemberSecretCodeService {
    public String generateSignUpCode();
    public String matchVerificationCodes(MemberSecretCodeDto memberSecretCodeDto);


}
