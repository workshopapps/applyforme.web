package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Submission;
import com.hydraulic.applyforme.repository.ViewSubmissionRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ViewSubmissionRepositoryImpl implements ViewSubmissionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Submission> getAll() {
        return null;
    }

    @Override
    public List<Submission> getAll(Integer pageOffSet) {
        return null;
    }

    @Override
    public Submission getOne(Long id) {
        return null;
    }

    @Override
    public Submission saveOne(Submission submission) {
        return null;
    }

    @Override
    public Submission updateOne(Submission submission) {
        return null;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

    @Override
    public boolean removeMany(List<Long> ids) {
        return false;
    }

    @Override
    public boolean removeAll() {
        return false;
    }
}
