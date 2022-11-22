package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Repository
public class MemberRepositoryImpl implements MemberRepository {
    private static final int DEFAULT_PAGE_SIZE = 11;
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Member findByEmailAddress(String emailAddress){
        String queryString = "SELECT m FROM Member m WHERE m.emailAddress = : emailAddress";
        Query query ;
        Member member = null;
        try{

            query = entityManager.createQuery(queryString);
            query.setParameter("emailAddress", emailAddress);
            member = (Member) query.getSingleResult();
        } catch (Exception ex) {

        }
        return  member;
    }

    @Override
    public void save(Member member) {
        entityManager.persist(member);
    }

    public boolean existsByEmailAddress(String emailAddress) {
        String queryString = "SELECT m FROM Member m WHERE m.emailAddress = : emailAddress";
        Query query ;
        Member member = null;
        boolean memberExists = false;
        try{

            query = entityManager.createQuery(queryString);
            query.setParameter("emailAddress", emailAddress);
            member = (Member) query.getSingleResult();
            if (member != null) {
                memberExists = true;
            }
        } catch (Exception ex) {
        }
        return memberExists;
    }

    @Override
    public void updatePassword(String emailAddress, String newPassword){
        String queryString = "SELECT m FROM Member m WHERE m.emailAddress = : emailAddress";
        Query query ;
        Member member = null;
        try{
            query = entityManager.createQuery(queryString);
            query.setParameter("email_address", emailAddress);
            member = (Member) query.getSingleResult();
            member.setPassword(newPassword);
            entityManager.merge(member);
        } catch (Exception ex) {

        }
    }


}

