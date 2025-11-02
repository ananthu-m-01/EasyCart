package com.ananthudev.EasyCart.service.seller;

import com.ananthudev.EasyCart.dto.seller.CreateSellerDTO;
import com.ananthudev.EasyCart.dto.seller.SellerResponseDTO;
import com.ananthudev.EasyCart.dto.seller.SellerUpdateDTO;
import com.ananthudev.EasyCart.exceptions.seller.SellerNotFoundException;
import com.ananthudev.EasyCart.model.Seller;
import com.ananthudev.EasyCart.repository.SellerRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SellerService implements ISellerService{

    private final SellerRepository sellerRepository;

    private SellerService (SellerRepository sellerRepository){
        this.sellerRepository = sellerRepository;
    }

    @Override
    public List<SellerResponseDTO> findAllSellers() {
        return sellerRepository.findAll()
                .stream().map(Seller::toSellerResponseDTO)
                .toList();
    }

    @Override
    public SellerResponseDTO findSellerByID(Long id) {
        return sellerRepository.findById(id).map(Seller::toSellerResponseDTO)
                .orElseThrow(()-> new SellerNotFoundException("seller not found with id : "+id));
    }

    @Override
    public SellerResponseDTO addSeller(@Valid CreateSellerDTO createSellerDTO) {

        Seller seller = Seller.builder()
                .name(createSellerDTO.getName())
                .email(createSellerDTO.getEmail())
                .businessName(createSellerDTO.getBusinessName())
                .phoneNumber(createSellerDTO.getPhoneNumber())
                .GSTNumber(createSellerDTO.getGSTNumber())
                .password(createSellerDTO.getPassword())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        Seller savedSeller = sellerRepository.save(seller);

        return savedSeller.toSellerResponseDTO();
    }

    @Override
    public SellerResponseDTO updateSeller(Long id, @Valid SellerUpdateDTO sellerUpdateDTO) {
        boolean exist = sellerRepository.findAll().stream().anyMatch(s -> s.getId().equals(id));
        if(!exist){
            throw new SellerNotFoundException("seller not find with the id : "+id);
        }
        Seller existingSeller = sellerRepository.findById(id).orElseThrow(()->new SellerNotFoundException("seller not found"));

        Seller updatedSeller = Seller.builder()
                .id(existingSeller.getId())
                .email(existingSeller.getEmail())
                .name(sellerUpdateDTO.getName())
                .businessName(sellerUpdateDTO.getBusinessName())
                .password(sellerUpdateDTO.getPassword())
                .phoneNumber(sellerUpdateDTO.getPhoneNumber())
                .GSTNumber(existingSeller.getGSTNumber())
                .createdAt(existingSeller.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();

        Seller savedSeller = sellerRepository.save(updatedSeller);

        return savedSeller.toSellerResponseDTO();
    }

    @Override
    public ResponseEntity<String> deleteSeller(Long id) {
        boolean exist = sellerRepository.findAll().stream().anyMatch(s->s.getId().equals(id));
        if(!exist){
            throw new SellerNotFoundException("seller not found with id : "+id);
        }
        sellerRepository.deleteById(id);
        return ResponseEntity.ok("seller deleted");
    }
}
