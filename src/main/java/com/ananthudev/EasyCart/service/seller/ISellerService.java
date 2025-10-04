package com.ananthudev.EasyCart.service.seller;

import com.ananthudev.EasyCart.dto.seller.CreateSellerDTO;
import com.ananthudev.EasyCart.dto.seller.SellerResponseDTO;
import com.ananthudev.EasyCart.dto.seller.SellerUpdateDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISellerService {
    List<SellerResponseDTO> findAllSellers();
    SellerResponseDTO findSellerByID(Long id);
    SellerResponseDTO addSeller(CreateSellerDTO createSellerDTO);
    SellerResponseDTO updateSeller(Long id,SellerUpdateDTO sellerUpdateDTO);
    ResponseEntity<String> deleteSeller(Long id);
}
