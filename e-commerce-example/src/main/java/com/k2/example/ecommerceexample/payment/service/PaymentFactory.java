package com.k2.example.ecommerceexample.payment.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {

    private static PaymentFactory instance = new PaymentFactory();
    private Map<String, PaymentMethod> events = new HashMap<>();

    private PaymentFactory() {
        events.put(PaymentMethodCard.namespace, new PaymentMethodCard());
        events.put(PaymentMethodPix.namespace, new PaymentMethodPix());
    }

    public static PaymentFactory getInstance() {
        return instance;
    }

    public PaymentMethod createProcessor(String name) {
        return events.get(name);
    }
}