package com.todevelop.todevelop.products.services.products;

import com.todevelop.todevelop.products.services.products.model.ProductModel;
import com.todevelop.todevelop.products.services.products.model.TelecomProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface ProductRepository extends JpaRepository<ProductModel,String> {

    ProductModel findProductModelByProductType(TelecomProductType type);

    @Query("SELECT p from ProductModel p")
    List<ProductModel> getAllProducts();
}
