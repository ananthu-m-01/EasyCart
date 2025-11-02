package com.ananthudev.EasyCart.repository;

import com.ananthudev.EasyCart.dto.product.ProductResponseDTO;
import com.ananthudev.EasyCart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByCategoryId(Long categoryId);
    List<Product> findAllBySellerId(Long sellerId);
}
