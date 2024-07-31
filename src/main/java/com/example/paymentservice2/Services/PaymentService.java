package com.example.paymentservice2.Services;

import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;


public interface PaymentService {
    public String initatePayment(Long orderId,String name,int amount) throws RazorpayException;


}
