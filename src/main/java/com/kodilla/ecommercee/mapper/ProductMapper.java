package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    public Product mapToProduct(ProductDto productDto) {
        return new Product();
    }

    public ProductDto mapToProductDto(Product product) {
        return new ProductDto();
    }

    public List<ProductDto> mapToProductsDtos(List<Product> products) {
        return new ArrayList<>();
    }

    public List<Product> mapToProducts(List<ProductDto> productsDtos) {
        return new ArrayList<>();
    }
}
