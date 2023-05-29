package com.pagination.learn.service;

import com.pagination.learn.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> findAllProduct();
    Product findProductById(Long id);
    List<Product> findProductBySorting(String field);
    Page<Product> findProductPegination(int offset, int pageSize);


    /**
     *  we can all add field in parameter to find the product in pagination by sorting them
     *   Page<Product> findProductPegination(int offset, int pageSize,String field);
     **/


}
