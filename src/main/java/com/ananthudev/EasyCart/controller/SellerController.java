package com.ananthudev.EasyCart.controller;

import com.ananthudev.EasyCart.dto.seller.CreateSellerDTO;
import com.ananthudev.EasyCart.dto.seller.SellerResponseDTO;
import com.ananthudev.EasyCart.dto.seller.SellerUpdateDTO;
import com.ananthudev.EasyCart.service.seller.SellerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    private final SellerService sellerService;

    public SellerController (SellerService sellerService){
        this.sellerService = sellerService;
    }

    @GetMapping
    public List<SellerResponseDTO> getAllSellers(){
        return sellerService.findAllSellers();
    }

    @GetMapping("/{id}")
    public SellerResponseDTO getSellerById(@PathVariable Long id){
        return sellerService.findSellerByID(id);
    }

    @PostMapping
    public SellerResponseDTO createSeller(@RequestBody @Valid CreateSellerDTO createSellerDTO){
        System.out.println("called");
        return sellerService.addSeller(createSellerDTO);
    }

    @PutMapping("/{id}")
    public SellerResponseDTO updateSeller(@PathVariable Long id, @Valid @RequestBody SellerUpdateDTO sellerUpdateDTO){
        return sellerService.updateSeller(id,sellerUpdateDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSeller(@PathVariable Long id){
        return sellerService.deleteSeller(id);
    }
}
