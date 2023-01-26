package com.hydraulic.applyforme.repository.impl;

import com.hydraulic.applyforme.model.domain.PaymentPaystack;
import com.hydraulic.applyforme.model.exception.ApplyForMeDuplicateEntityException;
import com.hydraulic.applyforme.model.exception.PaymentDetailsNotSaveException;
import com.hydraulic.applyforme.repository.PaystackPaymentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PaystackPaymentRepositoryImpl implements PaystackPaymentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveOne(PaymentPaystack paymentPaystack) {
        try {
            entityManager.persist(paymentPaystack);;
        }
        catch (PaymentDetailsNotSaveException ex) {
            throw new PaymentDetailsNotSaveException("Paystack");
        }
    }
}
