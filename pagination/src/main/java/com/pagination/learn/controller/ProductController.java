package com.pagination.learn.controller;

import com.pagination.learn.model.Product;
import com.pagination.learn.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
       Product product1 =  productService.createProduct(product);
        return new ResponseEntity<Product>(product1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> allProduct(){
        List<Product> products = productService.findAllProduct();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    @GetMapping("/{field}")
    public List<Product> findBySorting(@PathVariable("field") String fieldName){
        return productService.findProductBySorting(fieldName);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<Product> findByPagination(@PathVariable int offset,@PathVariable int pageSize){
        return productService.findProductPegination(offset,pageSize);
    }
}
