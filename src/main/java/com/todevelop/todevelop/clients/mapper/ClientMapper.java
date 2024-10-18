package com.todevelop.todevelop.clients.mapper;

import com.todevelop.todevelop.clients.dto.Client;
import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {


    @Mappings({
            @Mapping(target = "memberId", source = "member.memberId"),
            @Mapping(target = "firstName", source = "member.firstName"),
            @Mapping(target = "lastName", source = "member.lastName"),
            @Mapping(target = "middleInitial", source = "member.middleInitial"),
            @Mapping(target = "dob", source = "member.dob"),
            @Mapping(target = "nickName", source = "member.nickName"),
            @Mapping(target = "avatar", source = "member.avatar"),
            @Mapping(target = "externalId", source = "member.externalId"),
            @Mapping(target = "mainElectronicAddress", source = "member.mainElectronicAddress"),
    })
    public abstract Client toDto(ClientsModel model);

    @Mappings({
            @Mapping(source = "memberId", target = "member.memberId"),
            @Mapping(source = "firstName", target = "member.firstName"),
            @Mapping(source = "lastName", target = "member.lastName"),
            @Mapping(source = "middleInitial", target = "member.middleInitial"),
            @Mapping(source = "dob", target = "member.dob"),
            @Mapping(source = "nickName", target = "member.nickName"),
            @Mapping(source = "avatar", target = "member.avatar"),
            @Mapping(source = "externalId", target = "member.externalId"),
            @Mapping(source = "mainElectronicAddress", target = "member.mainElectronicAddress"),
    })
    public abstract ClientsModel toModel(Client dto);
}
