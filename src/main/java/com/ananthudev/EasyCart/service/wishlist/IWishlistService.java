package com.ananthudev.EasyCart.service.wishlist;

import com.ananthudev.EasyCart.dto.wishlist.CreateWishlistDTO;
import com.ananthudev.EasyCart.dto.wishlist.ResponseWishlistDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IWishlistService {
    List<ResponseWishlistDTO> getWishlistByCustomerId(Long customerId);
    ResponseWishlistDTO createWishlist(CreateWishlistDTO createWishlistDTO);
    ResponseEntity<String> removeProductFromWishlist(Long customerId,Long productId);
    ResponseEntity<String> clearWishList(Long id);
}
