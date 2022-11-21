package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.country.CountryDto;
import com.hydraulic.applyforme.model.dto.member.UpdateMemberDto;
import org.springframework.transaction.annotation.Transactional;

public interface UpdateMemberService {

   @Transactional
  Member update(Long id, UpdateMemberDto body);

}
