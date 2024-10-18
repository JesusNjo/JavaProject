package com.todevelop.todevelop.products.orchestrators;

import com.todevelop.todevelop.products.dto.Product;
import com.todevelop.todevelop.products.mapper.ProductMapper;
import com.todevelop.todevelop.products.orchestrators.action.GetProductAction;
import com.todevelop.todevelop.products.services.products.model.TelecomProductType;
import com.todevelop.todevelop.products.services.products.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class GetProductActionImpl implements GetProductAction {
    private final ProductService productService;
    private final ProductMapper productMapper;
    @Override
    public Product findProductModelByProductType(TelecomProductType type) {
        return productMapper.toDto(
                productService.findProductModelByProductType(type)
        );
    }

    @Override
    public List<Product> getAllProducts() {
        return productService.getAllProducts().stream().map(productMapper::toDto).toList();
    }
}
