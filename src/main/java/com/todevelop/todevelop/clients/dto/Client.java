package com.todevelop.todevelop.clients.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Client implements Serializable {


    @Serial
    private static final long serialVersionUID = 5789494890793701084L;

    private String clientId;
    private String memberId;
    private String status;
    private String firstName;

    private String lastName;

    private String middleInitial;

    private Timestamp dob;

    private String nickName;

    private String avatar;

    private String externalId;

    private String mainElectronicAddress;
}
