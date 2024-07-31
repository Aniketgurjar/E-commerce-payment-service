package com.example.paymentservice2.controller;

import com.example.paymentservice2.Services.PaymentService;
import com.example.paymentservice2.dtos.InitiateRequestPaymentDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService=paymentService;
    }
    @PostMapping("/payments")
    public String InitiatePayment(@RequestBody InitiateRequestPaymentDto requestDto) {
String payment=null;
try{
    payment= paymentService.initatePayment(
            requestDto.getOrderId(),
            requestDto.getName(),
            requestDto.getAmount());

    }catch(Exception e){
        System.out.println(e.getMessage());

    }
return payment;

}
}
