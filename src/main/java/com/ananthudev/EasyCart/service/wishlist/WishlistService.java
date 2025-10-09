package com.ananthudev.EasyCart.service.wishlist;

import com.ananthudev.EasyCart.dto.wishlist.CreateWishlistDTO;
import com.ananthudev.EasyCart.dto.wishlist.ResponseWishlistDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService implements IWishlistService{
    @Override
    public List<ResponseWishlistDTO> getWishlistByCustomerId(Long customerId) {
        return List.of();
    }

    @Override
    public ResponseWishlistDTO createWishlist(CreateWishlistDTO createWishlistDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> removeProductFromWishlist(Long customerId,Long productId) {
        return null;
    }


    @Override
    public ResponseEntity<String> clearWishList(Long id) {
        return null;
    }
}
