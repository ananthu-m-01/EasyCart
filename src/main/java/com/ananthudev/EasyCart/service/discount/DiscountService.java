package com.ananthudev.EasyCart.service.discount;

import com.ananthudev.EasyCart.dto.discount.CreateDiscountDTO;
import com.ananthudev.EasyCart.dto.discount.ResponseDiscountDTO;
import com.ananthudev.EasyCart.dto.discount.UpdateDiscountDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService implements IDiscountService {
    @Override
    public List<ResponseDiscountDTO> getAllDiscounts() {
        return List.of();
    }

    @Override
    public ResponseDiscountDTO getDiscountById(Long id) {
        return null;
    }

    @Override
    public ResponseDiscountDTO addDiscount(CreateDiscountDTO createDiscountDTO) {
        return null;
    }

    @Override
    public ResponseDiscountDTO updateDiscount(Long id, UpdateDiscountDTO updateDiscountDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteDiscount(Long id) {
        return null;
    }

    @Override
    public ResponseDiscountDTO getDiscountByCode(String code) {
        return null;
    }
}
