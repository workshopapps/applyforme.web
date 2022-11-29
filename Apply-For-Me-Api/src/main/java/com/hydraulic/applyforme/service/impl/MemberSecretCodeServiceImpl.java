package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.MemberSecretCode;
import com.hydraulic.applyforme.model.dto.secretCode.MemberSecretCodeDto;
import com.hydraulic.applyforme.repository.MemberSecretCodeRepository;
import com.hydraulic.applyforme.service.MemberSecretCodeService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberSecretCodeServiceImpl implements MemberSecretCodeService {
    @Autowired
    private MemberSecretCodeRepository memberSecretCodeRepository;

    /*
    * This method is required when the user has entered the four digits
    *  codes in four different boxes(as seen in the figma design for password reset code. They are yet to add
    * the design for entering of sign up verification code. They implemented use of four different boxes
    * to enter the codes. So, I implemented the same for sign-up verification code). But, if we are to enter
    * all the digits in one box, then we will need to update this method.
    * This method collects the codes(numbers submitted) in the boxes and
    *  concatenates them before comparing them with the sign-up verification code stored in the database(which
    * was stored at sign-up . Take a look at this method: public Member save(SignupDto body)
    * */

    @Override
    public String matchVerificationCodes(MemberSecretCodeDto memberSecretCodeDto){
        String secretCode1 = memberSecretCodeDto.getFirstCode();
        String secretCode2 = memberSecretCodeDto.getSecondCode();
        String secretCode3 = memberSecretCodeDto.getThirdCode();
        String secretCode4 = memberSecretCodeDto.getFourthCode();

        String secretCode = secretCode1.trim() + secretCode2.trim() + secretCode3.trim() + secretCode4.trim();
        MemberSecretCode memberSecretCode = memberSecretCodeRepository.findBySignUpVerificationCode(secretCode);

        if(memberSecretCode != null) {
            return "valid verification code";
        }
        else{
            return  "invalid verification code";
        }
    }

    /*
    * Although we already implemented use of link for password reset,I created this method
    * in-case we want to revert to use of password code, which is already included in the
    * member secret code table.
    * */

    @Override
    public String createResetPasswordCode() {
        int[] numbers = new int[4];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 9);
        }
        String code = "" + numbers[0] + numbers[1] + numbers[2] + numbers[3] + "";
        return  code;
    }
}
