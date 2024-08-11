package com.sparta.msa_exam.product.dto;


import com.sparta.msa_exam.product.entity.Product;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private Long id;

    private String name;

    private Integer supply_price;

    public static ProductResponseDto fromEntity(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .supply_price(product.getSupply_price())
                .build();
    }

    public static List<ProductResponseDto> fromEntity(List<Product> productList) {
        return productList.stream()
                .map(ProductResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}
