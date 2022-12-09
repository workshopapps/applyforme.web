package com.hydraulic.applyforme.service.impl.superadmin;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.response.base.ApplyForMeResponse;
import com.hydraulic.applyforme.repository.jpa.SuperAdminRecruiterJpaRepository;
import com.hydraulic.applyforme.service.superadmin.SuperAdminApplicantService;
import com.hydraulic.applyforme.service.superadmin.SuperAdminRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.createPageable;

@Service
public class SuperAdminRecruiterServiceImpl implements SuperAdminRecruiterService {

    @Autowired
    private final SuperAdminApplicantService service;

    private final SuperAdminRecruiterJpaRepository repository;

    public SuperAdminRecruiterServiceImpl(SuperAdminApplicantService service, SuperAdminRecruiterJpaRepository repository) {
        this.service = service;
        this.repository = repository;
    }


    @Override
    @Transactional()
    public ApplyForMeResponse searchRecruitersByName(int pageNo,
                                                     int pageSize,
                                                     String sortBy,
                                                     String sortDir,
                                                     String q) {
        Page<Member> members = null;

        if (q != null && !q.trim().equals("")) {
            members = repository.searchRecruiterByName(createPageable(pageNo, pageSize, sortBy, sortDir), q);
        } else {
            members = repository.searchRecruiterByName(createPageable(pageNo, pageSize, sortBy, sortDir), q);
        }

        return service.getMemberResponse(members);
    }
}

