package com.ananthudev.EasyCart.service.product;

import com.ananthudev.EasyCart.dto.product.CreateProductDTO;
import com.ananthudev.EasyCart.dto.product.ProductResponseDTO;
import com.ananthudev.EasyCart.dto.product.ProductUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements  IProductService{
    @Override
    public ProductResponseDTO getProductById(Long id) {
        return null;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductResponseDTO addProducts(CreateProductDTO createProductDTO) {
        return null;
    }

    @Override
    public ProductResponseDTO updateProduct(Long id,ProductUpdateDTO productUpdateDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteProductById(Long id) {
        return null;
    }

    @Override
    public List<ProductResponseDTO> getProductsByCategory(Long categoryId) {
        return List.of();
    }

    @Override
    public List<ProductResponseDTO> getAllProductsBySeller(Long sellerId) {
        return List.of();
    }
}
