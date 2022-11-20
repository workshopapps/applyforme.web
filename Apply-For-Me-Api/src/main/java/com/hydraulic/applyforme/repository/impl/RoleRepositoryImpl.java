package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.exception.RoleDuplicateEntityException;
import com.hydraulic.applyforme.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;


@Repository
public class RoleRepositoryImpl implements RoleRepository {
    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAll() {
        String queryText = "select c from Role c order by c.updatedOn desc";
        TypedQuery<Role> applyForMeQuery = entityManager.createQuery(queryText, Role.class);
        return applyForMeQuery.getResultList();
    }

    @Override
    public List<Role> getAll(Integer pageOffset) {
        String queryText = "select r from Role r order by r.updatedOn desc";
        TypedQuery<Role> applyForMeQuery = entityManager.createQuery(queryText, Role.class);

        applyForMeQuery.setFirstResult((pageOffset - 1) * DEFAULT_PAGE_SIZE);
        applyForMeQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return applyForMeQuery.getResultList();
    }

    @Override
    public Role getOne(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role saveOne(Role body) {
        try {
            entityManager.persist(body);
            return body;
        }
        catch (EntityExistsException ex) {
            throw new RoleDuplicateEntityException();
        }
    }

    @Override
    public Role updateOne(Role body) {
        return entityManager.merge(body);
    }

    @Override
    public boolean remove(Long id) {
        try {
            Role applyForMe = entityManager.getReference(Role.class, id);
            entityManager.remove(applyForMe);
            return true;
        }
        catch (EntityNotFoundException ex) {
            return false;
        }
    }

    @Override
    public boolean removeMany(List<Long> ids) {
        Query query = entityManager.createQuery("delete from Role r where r.id in (:ids)");
        query.setParameter("ids", ids);
        if (query.executeUpdate() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean removeAll() {
        Query query = entityManager.createQuery("delete from Role");
        if (query.executeUpdate() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
