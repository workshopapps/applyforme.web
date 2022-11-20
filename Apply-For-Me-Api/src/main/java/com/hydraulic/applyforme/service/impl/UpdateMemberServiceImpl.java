package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.mapper.UpdateMemberMapper;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.UpdateMemberDto;
import com.hydraulic.applyforme.repository.impl.UpdateMemberRepository;
import com.hydraulic.applyforme.service.UpdateMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateMemberServiceImpl implements UpdateMemberService {

    @Autowired
    private UpdateMemberRepository memberRepository;

    @Autowired
    private UpdateMemberMapper memberMapper;


    @Override
    public UpdateMemberDto updateMember(long id) {

        UpdateMemberDto member = memberMapper.modelToDto(memberRepository.findById(id));

        if (member != null) {
            return new UpdateMemberDto(member);
        }
        return null;
    }

}
