package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.MemberSecretCode;
import com.hydraulic.applyforme.model.dto.secretCode.MemberSecretCodeDto;
import com.hydraulic.applyforme.repository.MemberSecretCodeRepository;
import com.hydraulic.applyforme.service.MemberSecretCodeService;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberSecretCodeServiceImpl implements MemberSecretCodeService {

    @Autowired
    private MemberSecretCodeRepository memberSecretCodeRepository;


    @Override
    public String generateSignUpCode(){
        int[] numbers = new int[4];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 9);
        }
        String code = "" + numbers[0] + numbers[1] + numbers[2] + numbers[3] + "";
        return  code;
    }

    @Override
    public String matchVerificationCodes(MemberSecretCodeDto memberSecretCodeDto){
        String secretCode1 = memberSecretCodeDto.getFirstCode();
        String secretCode2 = memberSecretCodeDto.getSecondCode();
        String secretCode3 = memberSecretCodeDto.getThirdCode();
        String secretCode4 = memberSecretCodeDto.getFourthCode();

        String secretCode = secretCode1.trim() + secretCode2.trim() + secretCode3.trim() + secretCode4.trim();
        MemberSecretCode memberSecretCode = memberSecretCodeRepository.findBySignUpVerificationCode(secretCode);

        if(memberSecretCode != null) {
            return "valid_verification_code";
        }
        else{
            return  "invalid_verification_code";
        }
    }




}
