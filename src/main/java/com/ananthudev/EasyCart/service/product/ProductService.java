package com.ananthudev.EasyCart.service.product;

import com.ananthudev.EasyCart.dto.product.CreateProductDTO;
import com.ananthudev.EasyCart.dto.product.ProductResponseDTO;
import com.ananthudev.EasyCart.dto.product.ProductUpdateDTO;
import com.ananthudev.EasyCart.exceptions.category.CategoryNotFoundException;
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
        return null;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductResponseDTO addProducts(CreateProductDTO createProductDTO) {
        Seller seller = sellerRepository.findById(createProductDTO.getSellerId()).
                orElseThrow(
                        ()-> new SellerNotFoundException("seller not found with id : "+createProductDTO.getSellerId()));
        Category category = categoryRepository.findById(createProductDTO.getCategoryId()).
                orElseThrow(
                        ()-> new CategoryNotFoundException("category not found with id : "+createProductDTO.getCategoryId()));
        Discount discount = null;
        if (createProductDTO.getDiscountId() != null) {
            discount = discountRepository.findById(createProductDTO.getDiscountId())
                    .orElseThrow(() -> new RuntimeException("Discount not found"));
        }

        Product product = new Product();
        product.setSeller(seller);
        product.setCategory(category);
        product.setDiscount(discount);
        product.setName(createProductDTO.getName());
        product.setDescription(createProductDTO.getDescription());
        product.setPrice(createProductDTO.getPrice());
        product.setQuantity(createProductDTO.getQuantity());
        product.setStockUnit(createProductDTO.getStockUnit());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);

        return new ProductResponseDTO(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getDescription(),
                savedProduct.getPrice(),
                savedProduct.getQuantity(),
                savedProduct.getStockUnit(),
                savedProduct.getCategory().getName(),
                savedProduct.getSeller().getName(),
                savedProduct.getDiscount() != null ? savedProduct.getDiscount().getCode() : null,
                savedProduct.getCreatedAt()
        );
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
