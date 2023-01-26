package com.hydraulic.applyforme.controller.payment;

import com.hydraulic.applyforme.model.dto.payment.paystack.CreatePlanDto;
import com.hydraulic.applyforme.model.dto.payment.paystack.InitializePaymentDto;
import com.hydraulic.applyforme.model.response.payment.paystack.CreatePlanResponse;
import com.hydraulic.applyforme.model.response.payment.paystack.InitializePaymentResponse;
import com.hydraulic.applyforme.model.response.payment.paystack.PaymentVerificationResponse;
import com.hydraulic.applyforme.service.payment.PaystackService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "/paystack",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class PaystackController {

    private final PaystackService paystackService;

    public PaystackController(PaystackService paystackService) {
        this.paystackService = paystackService;
    }

    @PreAuthorize("hasRole('Professional')")
    @PostMapping("/createplan")
    public CreatePlanResponse createPlan(@Validated @RequestBody CreatePlanDto createPlanDto) throws Exception {
        return paystackService.createPlan(createPlanDto);
    }

    @PreAuthorize("hasRole('Professional')")
    @PostMapping("/initializepayment")
    public InitializePaymentResponse initializePayment(@Validated @RequestBody InitializePaymentDto initializePaymentDto) throws Throwable {
        return paystackService.initializePayment(initializePaymentDto);
    }

    @PreAuthorize("hasRole('Professional')")
    @GetMapping("/verifypayment/{reference}/{plan}")
    public PaymentVerificationResponse paymentVerification(@PathVariable(value = "reference") String reference,
                                                           @PathVariable(value = "plan") String plan) throws Exception {
        if (reference.isEmpty() || plan.isEmpty()) {
            throw new Exception("reference and plan must be provided in path");
        }
        return paystackService.paymentVerification(reference, plan);
    }
}
