package com.ananthudev.EasyCart.repository;

import com.ananthudev.EasyCart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
