package com.todevelop.todevelop.members.mapper;

import com.todevelop.todevelop.members.dto.Member;
import com.todevelop.todevelop.members.services.member.model.MemberModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class MemberMapper {


    public abstract Member toDto(MemberModel model);
    public abstract MemberModel toModel(Member dto);
}
