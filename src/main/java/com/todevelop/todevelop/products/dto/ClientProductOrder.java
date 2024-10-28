package com.todevelop.todevelop.products.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@AllArgsConstructor
public class ClientProductOrder implements Serializable {

    @Serial
    private static final long serialVersionUID = 6460082143228266878L;


    private String clientId;

    private String productId;

    private Double productPrice;

    private Integer orderQuantity;

    private Double totalPay;

    private String status;
}
