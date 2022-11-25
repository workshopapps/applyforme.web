package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.superadmin.MemberDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface SuperAdminService {

    Member getDetailsById(Long id);
    boolean deleteMemberById(Long id);
    Member getAdmin(Long id);
    Member addAdmin(MemberDto memberDto);
    List<Member> sortAndPaginateAdmin(Optional<Role> role, int pageNo, int pageSize, String sortBy, String sortDir);

}
