package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.repository.MemberSecretCodeRepository;
import com.hydraulic.applyforme.service.MemberSecretCodeService;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberSecretCodeServiceImpl implements MemberSecretCodeService {
    @Autowired
    private MemberSecretCodeRepository memberSecretCodeRepository;

    public String generateSignUpCode(){
        int[] numbers = new int[4];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 9);
        }
        String code = "" + numbers[0] + numbers[1] + numbers[2] + numbers[3] + "";
        return  code;
    };

    public void sendSignUpVerificationEmail(){

    };
}
