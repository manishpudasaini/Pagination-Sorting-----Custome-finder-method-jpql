package com.pagination.learn.service;

import com.pagination.learn.model.Product;
import com.pagination.learn.repo.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> findProductBySorting(String field) {
        return productRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    @Override
    public Page<Product> findProductPegination(int offset, int pageSize) {
        Page<Product> productPage = productRepo.findAll(PageRequest.of(offset, pageSize));
        return productPage;
    }
}
