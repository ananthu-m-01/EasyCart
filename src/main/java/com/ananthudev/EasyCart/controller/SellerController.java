package com.ananthudev.EasyCart.controller;

import com.ananthudev.EasyCart.dto.seller.CreateSellerDTO;
import com.ananthudev.EasyCart.dto.seller.SellerResponseDTO;
import com.ananthudev.EasyCart.dto.seller.SellerUpdateDTO;
import com.ananthudev.EasyCart.service.seller.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerController {

    private final SellerService sellerService;

    private SellerController(SellerService sellerService){
        this.sellerService = sellerService;
    }

    @GetMapping("/sellers")
    public List<SellerResponseDTO> getAllSellers(){
        return sellerService.findAllSellers();
    }

    @GetMapping("/sellers/{id}")
    public SellerResponseDTO getSellerById(@PathVariable Long id){
        return sellerService.findSellerByID(id);
    }

    @PostMapping("/sellers")
    public SellerResponseDTO createSeller(@RequestBody CreateSellerDTO createSellerDTO){
        return sellerService.addSeller(createSellerDTO);
    }

    @PutMapping("/sellers/{id}")
    public SellerResponseDTO updateSeller(@PathVariable Long id,@RequestBody SellerUpdateDTO sellerUpdateDTO){
        return sellerService.updateSeller(id,sellerUpdateDTO);
    }

    @DeleteMapping("/sellers/{id}")
    public ResponseEntity<String> deleteSeller(@PathVariable Long id){
        return sellerService.deleteSeller(id);
    }
}
