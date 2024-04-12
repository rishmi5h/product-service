package com.rishmi5h.microservices.product.service;

import com.rishmi5h.microservices.product.dto.ProductRequest;
import com.rishmi5h.microservices.product.dto.ProductResponse;
import com.rishmi5h.microservices.product.model.Product;
import com.rishmi5h.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
  private final ProductRepository productRepository;

  public ProductResponse createProduct(ProductRequest productRequest){
    Product product = Product.builder()
            .name(productRequest.name())
            .description(productRequest.description())
            .price(productRequest.price())
            .build();
    productRepository.save(product);
    log.info("Product created successfully");
    return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
  }

  public List<ProductResponse> getAllProducts(){
    log.info("Searching products");
    return  productRepository.findAll()
            .stream()
            .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
            .toList();
  }

}
