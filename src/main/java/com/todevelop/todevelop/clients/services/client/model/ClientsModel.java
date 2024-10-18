package com.todevelop.todevelop.clients.services.client.model;

import com.todevelop.todevelop.members.services.member.model.MemberModel;
import com.todevelop.todevelop.utils.AuditBaseModel;
import com.todevelop.todevelop.utils.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "clients")
@NoArgsConstructor
@Builder
public class ClientsModel extends AuditBaseModel implements Serializable {

    @Id
    @Column(name = "client_id", nullable = false)
    private String clientId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private MemberModel member;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status;


}
