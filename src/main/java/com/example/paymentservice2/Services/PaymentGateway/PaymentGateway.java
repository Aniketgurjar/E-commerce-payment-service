package com.example.paymentservice2.Services.PaymentGateway;

import com.razorpay.RazorpayException;

public interface PaymentGateway {
    String generatePaymentLink(Long orderId,String name,int amount) throws RazorpayException;
    boolean validatePayment(Long orderId);
}
