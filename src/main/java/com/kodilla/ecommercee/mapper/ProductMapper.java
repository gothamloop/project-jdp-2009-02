package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getAmount()
        );
    }

    public ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getAmount()
        );
    }

    public List<ProductDto> mapToProductsDtos(final List<Product> products) {
        return products.stream()
                .map(p -> new ProductDto(p.getName(), p.getDescription(), p.getPrice(), p.getAmount()))
                .collect(Collectors.toList());
    }

    public List<Product> mapToProducts(List<ProductDto> productsDtos) {
        return productsDtos.stream()
                .map(p -> new Product(p.getName(), p.getDescription(), p.getPrice(), p.getAmount()))
                .collect(Collectors.toList());
    }
}
