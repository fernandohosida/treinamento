package com.k2.example.ecommerceexample.payment.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentMethodPix implements PaymentMethod {

    public static String namespace = "pix";

    @Override
    public String pay(String pay) {
        System.out.println("payment by Pix " + pay);
        return "payment by Pix";
    }
}
