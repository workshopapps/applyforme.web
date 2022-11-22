package com.hydraulic.applyforme.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.role.RoleDto;
import com.hydraulic.applyforme.model.dto.role.DeleteManyRoleDto;
import com.hydraulic.applyforme.model.exception.RoleDuplicateEntityException;
import com.hydraulic.applyforme.model.exception.RoleNotFoundException;
import com.hydraulic.applyforme.repository.RoleRepository;
import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
import com.hydraulic.applyforme.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.hydraulic.applyforme.util.ApplyForMeUtil.readResourceFile;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final RoleJpaRepository jpaRepository;

    public RoleServiceImpl(RoleRepository repository, RoleJpaRepository jpaRepository) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
    }

    @Override
    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void seedRoleRecords() throws JsonProcessingException {

        String roleJsonAsString = readResourceFile("json/roles.json");

        ObjectMapper mapper = new ObjectMapper();

        Role[] countriesArray = mapper.readValue(roleJsonAsString, Role[].class);
        List<Role> rolesList = Arrays.asList(countriesArray);

        try {
            for (Role role : rolesList) {
                if (false) {
                    Optional<Role> roleExists = jpaRepository.findByTitleAndCode(role.getTitle(), role.getCode());

                    if (roleExists.isPresent()) {
                        continue;
                    }

                    role.setId(null);
                    repository.saveOne(role);
                }
            }
        }
        catch (RoleDuplicateEntityException exception) {
            /**
             * If a duplicate entry exists, it means we don't need to reinsert or save it as new row or entity in the database.
             * It means we will ignore.
             */
        }
    }

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Role> findAll(Integer pageOffset) {
        return repository.getAll(pageOffset);
    }

    @Override
    public List<Role> findAll() {
        return repository.getAll();
    }

    @Override
    public Role findOne(Long id) {
        Role role = repository.getOne(id);
        if (role == null) {
            throw new RoleNotFoundException(id);
        }
        return role;
    }

    @Override
    @Transactional
    public Role save(RoleDto body) {
        Role role = new Role();
        role = modelMapper.map(body, Role.class);
        return repository.updateOne(role);
    }

    @Override
    @Transactional
    public Role update(Long id, RoleDto body) {
        Role existingRole = repository.getOne(id);
        if (existingRole == null) {
            throw new RoleNotFoundException(id);
        }

        Role role = new Role();
        role = modelMapper.map(body, Role.class);
        role.setId(id);
        return repository.updateOne(role);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean removed = repository.remove(id);
        if (removed) {
            return true;
        }
        else {
            throw new RoleNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public boolean deleteMany(DeleteManyRoleDto manyDto) {
        return repository.removeMany(manyDto.getIds());
    }

    @Override
    @Transactional
    public boolean deleteAll() {
        return repository.removeAll();
    }
}
