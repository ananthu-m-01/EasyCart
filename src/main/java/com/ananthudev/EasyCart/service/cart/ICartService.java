package com.ananthudev.EasyCart.service.cart;

import com.ananthudev.EasyCart.dto.cart.CartCreateDTO;
import com.ananthudev.EasyCart.dto.cart.CartResponseDTO;
import com.ananthudev.EasyCart.dto.cart.CartUpdateDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICartService {

    List<CartResponseDTO> getAllCartProducts(Long customerId);
    CartResponseDTO addToCart(Long customerId, CartCreateDTO cartCreateDTO);
    CartResponseDTO updateCart(Long customerId, CartUpdateDTO cartUpdateDTO);
    ResponseEntity<String> removeProductFromCartById(Long customerId,Long productId);
    ResponseEntity<String> removeAllProductFromCart(Long customerId);
}
