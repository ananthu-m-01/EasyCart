package com.ananthudev.EasyCart.service.product;

import com.ananthudev.EasyCart.dto.product.CreateProductDTO;
import com.ananthudev.EasyCart.dto.product.ProductResponseDTO;
import com.ananthudev.EasyCart.dto.product.ProductUpdateDTO;
import com.ananthudev.EasyCart.exceptions.category.CategoryNotFoundException;
import com.ananthudev.EasyCart.exceptions.discount.DiscountNotFoundException;
import com.ananthudev.EasyCart.exceptions.product.ProductNotFoundException;
import com.ananthudev.EasyCart.exceptions.seller.SellerNotFoundException;
import com.ananthudev.EasyCart.model.Category;
import com.ananthudev.EasyCart.model.Discount;
import com.ananthudev.EasyCart.model.Product;
import com.ananthudev.EasyCart.model.Seller;
import com.ananthudev.EasyCart.repository.CategoryRepository;
import com.ananthudev.EasyCart.repository.DiscountRepository;
import com.ananthudev.EasyCart.repository.ProductRepository;
import com.ananthudev.EasyCart.repository.SellerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService implements  IProductService{
    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;
    private final CategoryRepository categoryRepository;
    private final DiscountRepository discountRepository;

    public ProductService(ProductRepository productRepository, SellerRepository sellerRepository, CategoryRepository categoryRepository, DiscountRepository discountRepository){
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
        this.categoryRepository = categoryRepository;
        this.discountRepository = discountRepository;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(Product::toProductResponseDTO)
                .orElseThrow(()-> new ProductNotFoundException("product not found with id "+id));
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(Product::toProductResponseDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO addProducts(CreateProductDTO createProductDTO) {

        Seller seller = sellerRepository
                .findById(createProductDTO.getSellerId())
                .orElseThrow(() -> new SellerNotFoundException(""));
        Category category = categoryRepository
                .findById(createProductDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(""));
        Discount discount = discountRepository
                .findById(createProductDTO.getDiscountId())
                .orElseThrow(() -> new DiscountNotFoundException(""));

        Product product = Product.builder()
                .seller(seller)
                .category(category)
                .discount(discount)
                .name(createProductDTO.getName())
                .description(createProductDTO.getDescription())
                .price(createProductDTO.getPrice())
                .quantity(createProductDTO.getQuantity())
                .stockUnit(createProductDTO.getStockUnit())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        productRepository.save(product);
        return product.toProductResponseDTO();
    }

    @Override
    public ProductResponseDTO updateProduct(Long id,ProductUpdateDTO productUpdateDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("product not found with id "+ id));

        Seller seller = sellerRepository
                .findById(productUpdateDTO.getSellerId())
                .orElseThrow(()-> new SellerNotFoundException("seller not found with id "+productUpdateDTO.getSellerId()));

        Category category = categoryRepository
                .findById(productUpdateDTO.getCategoryId())
                .orElseThrow(()-> new CategoryNotFoundException("category not found id "+productUpdateDTO.getCategoryId()));

        Discount discount = discountRepository
                .findById(productUpdateDTO.getDiscountId())
                .orElseThrow(()-> new DiscountNotFoundException("discount not found with id "+productUpdateDTO.getDiscountId()));

        Product updatedProduct = Product.builder()
                .id(existingProduct.getId())
                .seller(seller)
                .category(category)
                .discount(discount)
                .name(productUpdateDTO.getName())
                .description(productUpdateDTO.getDescription())
                .price(productUpdateDTO.getPrice())
                .quantity(productUpdateDTO.getQuantity())
                .stockUnit(productUpdateDTO.getStockUnit())
                .createdAt(existingProduct.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();

        Product savedProduct = productRepository.save(updatedProduct);
        return savedProduct.toProductResponseDTO();
    }

    @Override
    public ResponseEntity<String> deleteProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("product not found with id : "+id));
        productRepository.delete(product);
        return ResponseEntity.ok("product deleted successfully");
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
