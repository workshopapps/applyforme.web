package com.hydraulic.applyforme.service.impl.superadmin;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.member.MemberDto;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.SuperAdminApplierJpaRepository;
import com.hydraulic.applyforme.service.superadmin.SuperAdminApplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.createPageable;

@Service
public class SuperAdminApplierServiceImpl implements SuperAdminApplierService {

    private SuperAdminApplierJpaRepository jpaRepository;
    
    @Autowired
    private ModelMapper mapper;

    public SuperAdminApplierServiceImpl(SuperAdminApplierJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ApplyForMeResponse getEntries(int pageNo, int pageSize, String sortBy, String sortDir, String q, Date from, Date to) {
        Page<Member> members = null;

        if (from != null && to != null && q != null && q.trim() != "") {
            members = jpaRepository.getEntries(from, to, q, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        else if (from != null && to != null) {
            members = jpaRepository.getEntries(from, to, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        if (q != null && q.trim() != "") {
            members = jpaRepository.getEntries(q, createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        else {
            members = jpaRepository.getEntries(createPageable(pageNo, pageSize, sortBy, sortDir));
        }
        return getApplierResponse(members);
    }
    private ApplyForMeResponse getApplierResponse(Page<Member> members) {
        Collection<MemberDto> results = members
                .getContent()
                .stream()
                .map(x -> {
                    return mapper.map(x, MemberDto.class);
                })
                .collect(Collectors.toList());

        ApplyForMeResponse entryResponse = new ApplyForMeResponse();
        entryResponse.setContent(results);
        entryResponse.setPageNo(members.getNumber());
        entryResponse.setPageSize(members.getSize());
        entryResponse.setTotalElements(members.getTotalElements());
        entryResponse.setTotalPages(members.getTotalPages());
        entryResponse.setLast(members.isLast());
        return entryResponse;
    }
}
