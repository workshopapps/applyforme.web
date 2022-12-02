package com.hydraulic.applyforme.service.impl.superadmin;

import com.hydraulic.applyforme.repository.jpa.SuperAdminJpaRepository;
import com.hydraulic.applyforme.service.superadmin.SuperAdminDetailsService;
import com.hydraulic.applyforme.service.superadmin.UpdateSuperAdminProfileService;
import com.hydraulic.applyforme.util.CurrentUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UpdateSuperAdminProfileServiceImpl implements UpdateSuperAdminProfileService {

    @Autowired
    SuperAdminJpaRepository repository;


    @Override
    @Transactional
    public Long getCurrentUser() {
        SuperAdminDetailsService currentUserUtil = CurrentUserUtil.getCurrentUser();
        System.out.println(currentUserUtil);


        return currentUserUtil.getUserId();
    }
}
