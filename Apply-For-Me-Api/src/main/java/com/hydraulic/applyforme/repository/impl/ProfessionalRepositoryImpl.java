package com.hydraulic.applyforme.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.ProfessionalProfile;
import com.hydraulic.applyforme.repository.ProfessionalRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ProfessionalRepositoryImpl implements ProfessionalRepository {

    private static final int DEFAULT_PAGE_SIZE = 11;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Professional> getAll(Integer pageOffset) {
        String queryString = "select p from Professional p order by p.member.updatedOn desc";
        TypedQuery<Professional> professionalQuery = entityManager.createQuery(queryString, Professional.class);

        professionalQuery.setFirstResult((pageOffset - 1) * DEFAULT_PAGE_SIZE);
        professionalQuery.setMaxResults(DEFAULT_PAGE_SIZE);
        return professionalQuery.getResultList();
    }

    @Override
    public Professional getOne(Long id) {
        return entityManager.find(Professional.class, id);
    }

    @Override
    public Professional getRef(Long id) {
        try {
            return entityManager.getReference(Professional.class, id);
        }
        catch (EntityNotFoundException ex) {
            return null;
        }
    }

    @Override
    public boolean remove(Long id) {
        try {
            Professional entity = entityManager.getReference(Professional.class, id);
            entityManager.remove(entity);
            return true;
        }
        catch (EntityNotFoundException ex) {
            return false;
        }
    }

    @Override
    public boolean removeMany(List<Long> ids) {
        Query query = entityManager.createQuery("delete from Professional p where p.id in (:ids)");
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
        Query query = entityManager.createQuery("delete from Professional");
        if (query.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Professional updateOne(Professional body) {
        return entityManager.merge(body);
    }
    
    @Override
	public List<ProfessionalProfile> getAllJobProfile(Long id, int pageOffset) {
		String query = "select pp from ProfessionalProfile pp where pp.professional.id = :professionalId order by pp.updatedOn ASC";
		TypedQuery<ProfessionalProfile> q = entityManager.createQuery(query, ProfessionalProfile.class);
		q.setParameter("professionalId", id);
		q.setFirstResult((pageOffset - 1) * DEFAULT_PAGE_SIZE );
		q.setMaxResults(DEFAULT_PAGE_SIZE);
		return q.getResultList();
	}
}
