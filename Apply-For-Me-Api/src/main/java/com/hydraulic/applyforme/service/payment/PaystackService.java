package com.hydraulic.applyforme.service.payment;

import com.hydraulic.applyforme.model.dto.payment.paystack.CreatePlanDto;
import com.hydraulic.applyforme.model.dto.payment.paystack.InitializePaymentDto;
import com.hydraulic.applyforme.model.response.payment.paystack.CreatePlanResponse;
import com.hydraulic.applyforme.model.response.payment.paystack.InitializePaymentResponse;
import com.hydraulic.applyforme.model.response.payment.paystack.PaymentVerificationResponse;

public interface PaystackService {
    CreatePlanResponse createPlan(CreatePlanDto createPlanDto) throws Exception;
    InitializePaymentResponse initializePayment(InitializePaymentDto initializePaymentDto);
    PaymentVerificationResponse paymentVerification(String reference, String plan) throws Exception;
}
