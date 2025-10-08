package com.ananthudev.EasyCart.service.cart;

import com.ananthudev.EasyCart.dto.cart.CartCreateDTO;
import com.ananthudev.EasyCart.dto.cart.CartResponseDTO;
import com.ananthudev.EasyCart.dto.cart.CartUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService{
    @Override
    public List<CartResponseDTO> getAllCartProducts(Long customerId) {
        return List.of();
    }

    @Override
    public CartResponseDTO addToCart(Long customerId, CartCreateDTO cartCreateDTO) {
        return null;
    }

    @Override
    public CartResponseDTO updateCart(Long customerId, CartUpdateDTO cartUpdateDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> removeProductFromCartById(Long customerId, Long productId) {
        return null;
    }

    @Override
    public ResponseEntity<String> removeAllProductFromCart(Long customerId) {
        return null;
    }
}
