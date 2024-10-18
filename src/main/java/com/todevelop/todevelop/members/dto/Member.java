package com.todevelop.todevelop.members.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
@Getter
@AllArgsConstructor
public class Member {

    private String memberId;
    private String firstName;

    private String lastName;

    private String middleInitial;

    private Timestamp dob;

    private String nickName;

    private String avatar;

    private String externalId;

    private String mainElectronicAddress;

    private String status;
}
