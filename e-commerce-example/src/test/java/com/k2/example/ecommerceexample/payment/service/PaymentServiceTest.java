package com.k2.example.ecommerceexample.payment.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PaymentServiceTest {

    private PaymentService paymentService;

    @BeforeEach
    void setup() {
        this.paymentService = new PaymentService();
    }

    @Test
    void testPaymentByCard() {

        String payment = paymentService.pay("card");

        assertThat(payment.equals("payment by Card"));
    }

    @Test
    void testPaymentByPix() {

        String payment = paymentService.pay("pix");

        assertThat(payment.equals("payment by Pix"));
    }
}