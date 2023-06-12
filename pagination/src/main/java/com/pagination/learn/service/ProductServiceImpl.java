package com.pagination.learn.service;

import com.pagination.learn.exception.ProductNotFoundexception;
import com.pagination.learn.model.Product;
import com.pagination.learn.repo.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Product findProductById(Long id) {
        Optional<Product> product =productRepo.findById(id);
        if(product.isPresent()){
            Product product1 = product.get();
            return product1;
        }else {
            throw new ProductNotFoundexception("Product having this id "+id+" is not in the database!!!!");
        }
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

    @Override
    public List<Product> findByname(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public List<Product> findByNameAndCity(String name, String city) {
        return productRepo.getproductByNameAndCity(name,city);
    }
}
