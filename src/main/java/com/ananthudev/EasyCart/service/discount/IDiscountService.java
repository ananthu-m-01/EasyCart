package com.ananthudev.EasyCart.service.discount;

import com.ananthudev.EasyCart.dto.discount.CreateDiscountDTO;
import com.ananthudev.EasyCart.dto.discount.ResponseDiscountDTO;
import com.ananthudev.EasyCart.dto.discount.UpdateDiscountDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDiscountService {
    List<ResponseDiscountDTO> getAllDiscounts();
    ResponseDiscountDTO getDiscountById(Long id);
    ResponseDiscountDTO addDiscount(CreateDiscountDTO createDiscountDTO);
    ResponseDiscountDTO updateDiscount(Long id, UpdateDiscountDTO updateDiscountDTO);
    ResponseEntity<String> deleteDiscount(Long id);
    ResponseDiscountDTO getDiscountByCode(String code);
}
