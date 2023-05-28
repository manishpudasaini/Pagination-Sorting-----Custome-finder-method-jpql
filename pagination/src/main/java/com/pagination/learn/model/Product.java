package com.pagination.learn.model;

import com.pagination.learn.quality.ProductQuality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    @Enumerated(EnumType.STRING)
    private ProductQuality productQuality=ProductQuality.Excellent;
    private String city;
}
