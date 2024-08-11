package com.sparta.msa_exam.product.controller;

import com.sparta.msa_exam.product.dto.ProductRequestDto;
import com.sparta.msa_exam.product.repository.ProductRepository;
import com.sparta.msa_exam.product.service.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequestDto requestDto,
                                           HttpServletResponse response) {

        response.addHeader("Server-Port", serverPort);

        return ResponseEntity.ok().body(productService.creatProduct(requestDto));
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProducts(HttpServletResponse response) {

        response.addHeader("Server-Port", serverPort);

        return ResponseEntity.ok().body(productService.getAllProduct());
    }


}
