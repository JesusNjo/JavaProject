package com.todevelop.todevelop.products.services.products.services;

import com.todevelop.todevelop.products.services.products.model.ProductModel;
import com.todevelop.todevelop.products.services.products.model.TelecomProductType;
import com.todevelop.todevelop.utils.GenericJPA;

import java.util.List;

public interface ProductService extends GenericJPA<ProductModel,String> {

    ProductModel findProductModelByProductType(TelecomProductType type);
    List<ProductModel> getAllProducts();
}
