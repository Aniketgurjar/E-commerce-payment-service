package com.example.paymentservice2.Services.PaymentGateway;

import org.springframework.stereotype.Service;

@Service("stripepaymentgateway")

public class stripePaymentGateway implements PaymentGateway{
    @Override
    public String generatePaymentLink(Long orderId, String name, int amount) {


        return null;
    }

    @Override
    public boolean validatePayment(Long orderId) {
        return false;
    }
}
