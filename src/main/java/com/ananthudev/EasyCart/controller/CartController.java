package com.ananthudev.EasyCart.controller;

import com.ananthudev.EasyCart.dto.cart.CartCreateDTO;
import com.ananthudev.EasyCart.dto.cart.CartResponseDTO;
import com.ananthudev.EasyCart.dto.cart.CartUpdateDTO;
import com.ananthudev.EasyCart.service.cart.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private final CartService cartService;

    private CartController (CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/carts/{customerId}")
    public List<CartResponseDTO> getAllCartProducts(@PathVariable Long customerId){
        return cartService.getAllCartProducts(customerId);
    }

    @PostMapping("/carts/{customerId}/add")
    public CartResponseDTO addToCart(@PathVariable Long customerId,@RequestBody CartCreateDTO cartCreateDTO){
        return cartService.addToCart(customerId,cartCreateDTO);
    }

    @PutMapping("/carts/{customerId}/update")
    public CartResponseDTO updateCart(@PathVariable Long customerId, @RequestBody CartUpdateDTO cartUpdateDTO){
        return cartService.updateCart(customerId,cartUpdateDTO);
    }

    @DeleteMapping("/carts/{customerId}/remove/{productId}")
    public ResponseEntity<String> removeProductFromCartById(@PathVariable Long customerId,@PathVariable Long productId){
        return cartService.removeProductFromCartById(customerId,productId);
    }

    @DeleteMapping("/carts/{customerId}/clear")
    public ResponseEntity<String> removeAllProductFromCart(@PathVariable Long customerId){
        return cartService.removeAllProductFromCart(customerId);
    }
}
