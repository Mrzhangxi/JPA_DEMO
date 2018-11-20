package com.zx.jpademo.repository;

import com.zx.jpademo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findById(String id);

    List<Product> findAllByProductDesc(String productDesc);

    Page<Product> findAllByProductDesc(String ProductDesc, Pageable pageable);
}
