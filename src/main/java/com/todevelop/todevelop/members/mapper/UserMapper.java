package com.todevelop.todevelop.members.mapper;

import com.todevelop.todevelop.members.dto.User;
import com.todevelop.todevelop.members.services.user.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Mappings({
            @Mapping(target = "memberId",source = "memberId.memberId")
    })
    public abstract User toDto(UserModel entity);
}
