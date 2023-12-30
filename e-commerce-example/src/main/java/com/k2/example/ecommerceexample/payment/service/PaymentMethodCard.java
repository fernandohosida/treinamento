package com.k2.example.ecommerceexample.payment.service;


import org.springframework.stereotype.Component;

@Component
public class PaymentMethodCard implements PaymentMethod {

    public static String namespace = "card";

    @Override
    public String pay(String pay) {
        System.out.println("payment by Card " + pay);
        return "payment by Card";
    }
}
