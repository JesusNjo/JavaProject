package com.todevelop.todevelop.members.services.member.model;

import com.todevelop.todevelop.utils.AuditBaseModel;
import com.todevelop.todevelop.utils.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "members")
@Builder
public class MemberModel extends AuditBaseModel implements Serializable {

    @Serial
    private static final long serialVersionUID = -2182464768477752636L;

    @Id
    @Column(name = "member_id", nullable = false)
    private String memberId;

    @Column(name = "first_name",length = 200)
    private String firstName;

    @Column(name = "last_name", length = 200)
    private String lastName;

    @Column(name = "middle_initial")
    private String middleInitial;

    @Column(name = "dob")
    private Timestamp dob;

    @Column(name = "nickname")
    private String nickName;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "main_electronic_address")
    private String mainElectronicAddress;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
