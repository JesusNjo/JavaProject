package com.todevelop.todevelop.members.services.user.model;



import com.todevelop.todevelop.members.services.member.model.MemberModel;
import com.todevelop.todevelop.utils.AuditBaseModel;
import com.todevelop.todevelop.utils.enums.StatusEnum;
import com.todevelop.todevelop.utils.enums.TypesRegister;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.io.Serial;
import java.io.Serializable;

@Validated
@Builder
@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class UserModel extends AuditBaseModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 8946194945719969315L;

    @Id
    @Column(name = "username", nullable = false, length = 255)
    @Email
    private String username;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private MemberModel member;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusEnum status;

    @Enumerated(EnumType.STRING)
    @Column(name = "registration_type_id", nullable = false, length = 16)
    private TypesRegister typesRegister;

    @Column(name = "default_user", nullable = false)
    private Boolean defaultUser;

}
