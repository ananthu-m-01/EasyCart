package com.ananthudev.EasyCart.service.product;

import com.ananthudev.EasyCart.dto.product.CreateProductDTO;
import com.ananthudev.EasyCart.dto.product.ProductResponseDTO;
import com.ananthudev.EasyCart.dto.product.ProductUpdateDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductService {
    ProductResponseDTO getProductById(Long id);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO addProducts(CreateProductDTO createProductDTO);
    ProductResponseDTO updateProduct(Long id,ProductUpdateDTO productUpdateDTO);
    ResponseEntity<String> deleteProductById(Long id);
    List<ProductResponseDTO> getAllProductsByCategory(Long categoryId);
    List<ProductResponseDTO> getAllProductsBySeller(Long sellerId);
}
