package com.ananthudev.EasyCart.service.seller;

import com.ananthudev.EasyCart.dto.seller.CreateSellerDTO;
import com.ananthudev.EasyCart.dto.seller.SellerResponseDTO;
import com.ananthudev.EasyCart.dto.seller.SellerUpdateDTO;
import com.ananthudev.EasyCart.exceptions.seller.DuplicateSellerException;
import com.ananthudev.EasyCart.exceptions.seller.SellerNotFoundException;
import com.ananthudev.EasyCart.model.Seller;
import com.ananthudev.EasyCart.repository.SellerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SellerService implements ISellerService{

    private final SellerRepository sellerRepository;

    public SellerService (SellerRepository sellerRepository){
        this.sellerRepository = sellerRepository;
    }

    @Override
    public List<SellerResponseDTO> findAllSellers() {
        List<Seller> sellers = sellerRepository.findAll();
        return sellers.stream()
                .map(seller -> new SellerResponseDTO(
                        seller.getName(),
                        seller.getEmail(),
                        seller.getPhoneNumber()
                )).toList();
    }

    @Override
    public SellerResponseDTO findSellerByID(Long id) {
        boolean exists = sellerRepository.findAll().stream().anyMatch(seller -> seller.getId().equals(id));
        if(!exists){
            throw new SellerNotFoundException("seller not found with id : "+id);
        }
        Seller seller = sellerRepository.findById(id).orElseThrow(()-> new SellerNotFoundException("seller not found with id : "+id));
        SellerResponseDTO sellerResponseDTO = new SellerResponseDTO();
        sellerResponseDTO.setName(seller.getName());
        sellerResponseDTO.setEmail(seller.getEmail());
        sellerResponseDTO.setPhoneNumber(seller.getPhoneNumber());

        return sellerResponseDTO;
    }

    @Override
    public SellerResponseDTO addSeller(CreateSellerDTO createSellerDTO) {
        boolean exist = sellerRepository.findAll().stream().anyMatch(s->s.getEmail().equalsIgnoreCase(createSellerDTO.getEmail()));
        if(exist){
            throw new DuplicateSellerException("seller already exist with given email "+createSellerDTO.getEmail());
        }

        Seller seller = new Seller();
        seller.setName(createSellerDTO.getName());
        seller.setEmail(createSellerDTO.getEmail());
        seller.setBusinessName(createSellerDTO.getBusinessName());
        seller.setPhoneNumber(createSellerDTO.getPhoneNumber());
        seller.setGSTNumber(createSellerDTO.getGSTNumber());
        seller.setPassword(createSellerDTO.getPassword());
        seller.setCreatedAt(LocalDateTime.now());
        seller.setUpdatedAt(LocalDateTime.now());

        Seller savedSeller = sellerRepository.save(seller);
        return new SellerResponseDTO(savedSeller.getName(),
                savedSeller.getEmail(),
                savedSeller.getPhoneNumber()
        );
    }

    @Override
    public SellerResponseDTO updateSeller(Long id, SellerUpdateDTO sellerUpdateDTO) {
        boolean exist = sellerRepository.findAll().stream().anyMatch(s -> s.getId().equals(id));
        if(!exist){
            throw new SellerNotFoundException("seller not find with the id : "+id);
        }

        return null;
    }

    @Override
    public ResponseEntity<String> deleteSeller(Long id) {
        return null;
    }
}
