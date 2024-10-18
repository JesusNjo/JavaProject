package com.todevelop.todevelop.products.orchestrators.action;

import com.todevelop.todevelop.products.dto.Product;
import com.todevelop.todevelop.products.services.products.model.TelecomProductType;

import java.util.List;


public interface GetProductAction {


    Product findProductModelByProductType(TelecomProductType type);

    List<Product> getAllProducts();
}
