package com.todevelop.todevelop.members.dto;

import com.todevelop.todevelop.members.services.member.model.MemberModel;
import com.todevelop.todevelop.utils.enums.StatusEnum;
import com.todevelop.todevelop.utils.enums.TypesRegister;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = -1902020216086680511L;

    private String username;

    private MemberModel memberId;

    private StatusEnum status;

    private TypesRegister typesRegister;

    private Boolean defaultUser;

}
