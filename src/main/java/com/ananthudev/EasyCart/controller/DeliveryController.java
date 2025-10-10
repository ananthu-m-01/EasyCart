package com.ananthudev.EasyCart.controller;

import com.ananthudev.EasyCart.dto.delivery.CreateDeliveryDTO;
import com.ananthudev.EasyCart.dto.delivery.ResponseDeliveryDTO;
import com.ananthudev.EasyCart.dto.delivery.UpdateDeliveryDTO;
import com.ananthudev.EasyCart.service.delivery.DeliveryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {
    private final DeliveryService deliveryService;

    private DeliveryController(DeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }

    @GetMapping("/deliveries")
    public List<ResponseDeliveryDTO> getAllDeliveries(){
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/deliveries/{id}")
    public ResponseDeliveryDTO getDeliveryById(@PathVariable Long id){
        return deliveryService.getDeliveryById(id);
    }

    @GetMapping("/deliveries/order/{orderId}")
    public ResponseDeliveryDTO getDeliveryByOrderId(@PathVariable Long orderId){
        return deliveryService.getDeliveryByOrderId(orderId);
    }

    @PostMapping("/deliveries")
    public ResponseDeliveryDTO createDelivery(@RequestBody CreateDeliveryDTO createDeliveryDTO){
        return deliveryService.addDelivery(createDeliveryDTO);
    }

    @PutMapping("/deliveries/{id}")
    public ResponseDeliveryDTO updateDelivery(@PathVariable Long id,@RequestBody UpdateDeliveryDTO updateDeliveryDTO){
        return deliveryService.updateDelivery(id,updateDeliveryDTO);
    }

    @DeleteMapping("/deliveries/{id}")
    public ResponseDeliveryDTO deleteDeliveryById(@PathVariable Long id){
        return deliveryService.deleteDeliveryById(id);
    }
}
