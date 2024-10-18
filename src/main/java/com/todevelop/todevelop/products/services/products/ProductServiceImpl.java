package com.todevelop.todevelop.products.services.products;

import com.todevelop.todevelop.products.services.products.model.ProductModel;
import com.todevelop.todevelop.products.services.products.model.TelecomProductType;
import com.todevelop.todevelop.products.services.products.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;
    @Override
    public Optional<ProductModel> findById(String var1) {
        return productDAO.findById(var1);
    }

    @Override
    public ProductModel save(ProductModel var1) {
        return productDAO.save(var1);
    }

    @Override
    public List<ProductModel> saveAll(List<ProductModel> var1) {
        return productDAO.saveAll(var1);
    }

    @Override
    public void delete(ProductModel var1) {
        productDAO.delete(var1);
    }

    @Override
    public ProductModel findProductModelByProductType(TelecomProductType type) {
        return productDAO.findProductModelByProductType(type);
    }

    @Override
    public List<ProductModel> getAllProducts() {
        return productDAO.getAllProducts();
    }
}
