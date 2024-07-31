package com.example.paymentservice2.Services;

import com.example.paymentservice2.Services.PaymentGateway.PaymentGateway;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements  PaymentService {
    PaymentGateway paymentGateway;
    public PaymentServiceImpl (@Qualifier("razorpaypaymentgateway") PaymentGateway paymentGateway){
        this.paymentGateway=paymentGateway;
    }
    @Override
    public String initatePayment(Long orderId, String name, int amount) throws RazorpayException {
        //call the payment gateway to generate link
        return paymentGateway.generatePaymentLink(orderId,name,amount);
    }
}
