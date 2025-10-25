package com.ananthudev.EasyCart.controller;

import com.ananthudev.EasyCart.dto.product.CreateProductDTO;
import com.ananthudev.EasyCart.dto.product.ProductResponseDTO;
import com.ananthudev.EasyCart.dto.product.ProductUpdateDTO;
import com.ananthudev.EasyCart.service.product.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    private ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductResponseDTO addProducts(@RequestBody CreateProductDTO createProductDTO){
        return productService.addProducts(createProductDTO);
    }


    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(@PathVariable Long id,@RequestBody ProductUpdateDTO productUpdateDTO){
        return productService.updateProduct(id,productUpdateDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        return productService.deleteProductById(id);
    }


    @GetMapping("/category/{categoryId}")
    public List<ProductResponseDTO> getAllProductByCategory(@PathVariable Long categoryId){
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping("/seller/{sellerId}")
    public List<ProductResponseDTO> getAllProductsBySeller(@PathVariable Long sellerId){
        return productService.getAllProductsBySeller(sellerId);
    }

}
