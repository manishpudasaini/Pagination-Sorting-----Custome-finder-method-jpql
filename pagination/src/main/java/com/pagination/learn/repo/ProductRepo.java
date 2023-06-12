package com.pagination.learn.repo;

import com.pagination.learn.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    List<Product> findByName(String name);

    @Query("select u FROM Product u where u.name=:n AND u.city=:c")
    List<Product> getproductByNameAndCity(@Param("n") String name,@Param("c") String city);
}
