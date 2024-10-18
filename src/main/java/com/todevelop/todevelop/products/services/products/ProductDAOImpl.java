package com.todevelop.todevelop.products.services.products;

import com.todevelop.todevelop.products.services.products.model.ProductModel;
import com.todevelop.todevelop.products.services.products.model.TelecomProductType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
class ProductDAOImpl implements ProductDAO{
    private final ProductRepository productRepository;
    @Override
    public Optional<ProductModel> findById(String var1) {
        return productRepository.findById(var1);
    }

    @Override
    public ProductModel save(ProductModel var1) {
        return productRepository.save(var1);
    }

    @Override
    public List<ProductModel> saveAll(List<ProductModel> var1) {
        return productRepository.saveAll(var1);
    }

    @Override
    public void delete(ProductModel var1) {
        productRepository.delete(var1);
    }

    @Override
    public ProductModel findProductModelByProductType(TelecomProductType type) {
        return productRepository.findProductModelByProductType(type);
    }

    @Override
    public List<ProductModel> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
