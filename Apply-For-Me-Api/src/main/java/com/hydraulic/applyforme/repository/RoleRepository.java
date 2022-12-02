package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Role;

import java.util.List;

public interface RoleRepository {

    List<Role> getAll();

    List<Role> getAll(Integer pageOffSet);

    Role getOne(Long id);

    Role getRef(Long id);

    Role saveOne(Role country);

    Role updateOne(Role country);

    boolean remove(Long id);

    boolean removeMany(List<Long> ids);

    boolean removeAll();
}

