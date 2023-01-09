package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.PaymentPaystack;

public interface PaystackPaymentRepository {
    void saveOne(PaymentPaystack paymentPaystack);
}
