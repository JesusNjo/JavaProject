package com.todevelop.todevelop.products.mapper;

import com.todevelop.todevelop.products.dto.ClientProductOrder;
import com.todevelop.todevelop.products.services.client_product_order.model.ClientProductOrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class ClientProductOrderMapper {

    @Mappings({
            @Mapping(target = "clientId",source = "clientProductOrderId.client.clientId"),
            @Mapping(target = "productId",source = "clientProductOrderId.product.productId"),
            @Mapping(target = "productPrice",source = "clientProductOrderId.product.price"),
    })
    public abstract ClientProductOrder toDto(ClientProductOrderModel entity);
    @Mappings({
            @Mapping(source = "clientId",target = "clientProductOrderId.client.clientId"),
            @Mapping(source = "productId",target = "clientProductOrderId.product.productId"),
            @Mapping(source = "productPrice",target = "clientProductOrderId.product.price"),
    })
    public abstract ClientProductOrderModel toModel(ClientProductOrder dto);
}
