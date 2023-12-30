package com.k2.example.ecommerceexample.payment.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String pay(String payment) {
        PaymentFactory paymentFactory = PaymentFactory.getInstance();

        return paymentFactory.createProcessor(payment).pay("pagamento");
    }
}
