package com.todevelop.todevelop.products.mapper;

import com.todevelop.todevelop.products.dto.Product;
import com.todevelop.todevelop.products.services.products.model.ProductModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    public abstract Product toDto(ProductModel model);
    public abstract ProductModel toModel(Product dto);
}
