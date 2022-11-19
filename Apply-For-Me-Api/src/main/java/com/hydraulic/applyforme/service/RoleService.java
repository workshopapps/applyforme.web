package com.hydraulic.applyforme.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.role.DeleteManyRoleDto;
import com.hydraulic.applyforme.model.dto.role.RoleDto;

import javax.transaction.Transactional;
import java.util.List;

public interface RoleService {

    void seedRoleRecords() throws JsonProcessingException;

    List<Role> findAll(Integer pageOffset);

    List<Role> findAll();

    Role findOne(Long id);

    @Transactional
    Role save(RoleDto body);

    @Transactional
    Role update(Long id, RoleDto body);

    @Transactional
    boolean delete(Long id);

    @Transactional
    boolean deleteMany(DeleteManyRoleDto countryDto);

    @Transactional
    boolean deleteAll();


}
