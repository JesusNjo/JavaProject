package com.todevelop.todevelop.products.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor

public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 6260915561361935673L;

    private String productId;

    private String productType;

    private String description;

    private Double price;

    private Timestamp activationDate;

    private String status;
}
