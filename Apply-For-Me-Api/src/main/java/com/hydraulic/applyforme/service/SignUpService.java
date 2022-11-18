package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.CreateAccountDto;

public interface SignUpService {
    Member signUp(CreateAccountDto body);
}
