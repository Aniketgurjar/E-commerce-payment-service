package com.example.paymentservice2.configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayClientConfig {
    @Value("${razorpay.Key.id}")
    private String razorPayKeyId;
    @Value("${razorpay.Key.secret}")

    private String razorPaySecretId;

    @Bean
    public RazorpayClient getRazorpayClient() throws RazorpayException {
return new RazorpayClient(razorPayKeyId,razorPaySecretId);
    }
}
