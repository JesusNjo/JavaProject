package com.todevelop.todevelop.products.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientProduct implements Serializable {
    @Serial
    private static final long serialVersionUID = 1114256364477590743L;


    private String clientProductId;

    private String clientId;
    private String memberId;

    private String firstName;

    private String lastName;

    private String middleInitial;

    private Timestamp dob;

    private String nickName;

    private String avatar;

    private String externalId;

    private String mainElectronicAddress;

    private String productId;

    private String productType;

    private String description;

    private Double price;

    private Timestamp activationDate;

    private String status;


}
