package com.example.paymentservice2.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiateRequestPaymentDto {
    private Long orderId;
    private String name;

    private int amount;

}
