package com.todevelop.todevelop.products.mapper;

import com.todevelop.todevelop.products.dto.ClientProduct;
import com.todevelop.todevelop.products.services.client_products.model.ClientProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class ClientProductMapper {

    @Mappings({
            @Mapping(target = "clientId",source = "client.clientId"),
            @Mapping(target = "memberId",source = "client.member.memberId" ),
            @Mapping(target = "firstName",source = "client.member.firstName"),
            @Mapping(target = "lastName",source = "client.member.lastName"),
            @Mapping(target = "dob",source = "client.member.dob"),
            @Mapping(target = "nickName",source = "client.member.nickName"),
            @Mapping(target = "avatar",source = "client.member.avatar"),
            @Mapping(target = "externalId",source = "client.member.externalId"),
            @Mapping(target = "mainElectronicAddress",source = "client.member.mainElectronicAddress"),
            @Mapping(target = "productId",source = "product.productId"),
            @Mapping(target = "productType",source = "product.productType"),
            @Mapping(target = "description",source = "product.description"),
            @Mapping(target = "price",source = "product.price"),
            @Mapping(target = "activationDate",source = "product.activationDate"),

    })
    public abstract ClientProduct toDto(ClientProductModel entity);
}
