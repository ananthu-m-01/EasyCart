package com.ananthudev.EasyCart.controller;

import com.ananthudev.EasyCart.dto.wishlist.CreateWishlistDTO;
import com.ananthudev.EasyCart.dto.wishlist.ResponseWishlistDTO;
import com.ananthudev.EasyCart.service.wishlist.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WishlistController {

    private final WishlistService wishlistService;

    private WishlistController(WishlistService wishlistService){
        this.wishlistService = wishlistService;
    }

    @GetMapping("/wishlists/{customerId}")
    public List<ResponseWishlistDTO> getWishlistByCustomerId(@PathVariable Long id){
        return wishlistService.getWishlistByCustomerId(id);
    }

    @PostMapping("/wishlists/{customerId}/add")
    public ResponseWishlistDTO createWishlist(@RequestBody CreateWishlistDTO createWishlistDTO){
        return wishlistService.createWishlist(createWishlistDTO);
    }

    @DeleteMapping("/wishlists/{customerId}/remove/{productId}")
    public ResponseEntity<String> removeProductFromWishlist(Long customerId,Long productId){
        return wishlistService.removeProductFromWishlist(customerId,productId);
    }

    @DeleteMapping("/wishlists/{customerId}/clear")
    public ResponseEntity<String> clearWishlist(Long id){
        return wishlistService.clearWishList(id);
    }
}
