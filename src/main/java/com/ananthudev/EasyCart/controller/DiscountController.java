package com.ananthudev.EasyCart.controller;

import com.ananthudev.EasyCart.dto.discount.CreateDiscountDTO;
import com.ananthudev.EasyCart.dto.discount.ResponseDiscountDTO;
import com.ananthudev.EasyCart.dto.discount.UpdateDiscountDTO;
import com.ananthudev.EasyCart.service.discount.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscountController {

    private final DiscountService discountService;

    private DiscountController(DiscountService discountService){
        this.discountService  = discountService;
    }

    @GetMapping("/discounts")
    public List<ResponseDiscountDTO> getAllDiscounts(){
            return discountService.getAllDiscounts();
    }

    @GetMapping("/discounts/{id}")
    private ResponseDiscountDTO getDiscountById(@PathVariable Long  id){
        return discountService.getDiscountById(id);
    }

    @PostMapping("/discounts")
    private ResponseDiscountDTO createDiscount(@RequestBody CreateDiscountDTO createDiscountDTO){
        return discountService.addDiscount(createDiscountDTO);
    }

    @PutMapping("/discounts/{id}")
    private ResponseDiscountDTO updateDiscount(@PathVariable Long id, @RequestBody UpdateDiscountDTO updateDiscountDTO){
        return discountService.updateDiscount(id,updateDiscountDTO);
    }

    @DeleteMapping("/discounts/{id}")
    private ResponseEntity<String> deleteDiscountById(@PathVariable Long id){
        return discountService.deleteDiscount(id);
    }

    @GetMapping("/discounts/code/{code}")
    private ResponseDiscountDTO getDiscountByCode(@PathVariable String code){
        return discountService.getDiscountByCode(code);
    }
}
