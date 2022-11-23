package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.MemberSecretCode;
import com.hydraulic.applyforme.repository.MemberSecretCodeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class MemberSecretCodeRepositoryImpl implements MemberSecretCodeRepository {
    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public MemberSecretCode findBySignUpVerificationCode(String signUpVerificationCode) {
        String queryString = "SELECT v FROM MemberSecretCode v WHERE v.signUpVerificationCode = : signUpVerificationCode";
        Query query ;
        MemberSecretCode memberSecretCode = null;
        try{

            query = entityManager.createQuery(queryString);
            query.setParameter("signUpVerificationCode", signUpVerificationCode);
            memberSecretCode = (MemberSecretCode) query.getSingleResult();
        } catch (Exception ex) {

        }
        return memberSecretCode;
    }
}
