package com.ananthudev.EasyCart.service.delivery;

import com.ananthudev.EasyCart.dto.delivery.CreateDeliveryDTO;
import com.ananthudev.EasyCart.dto.delivery.ResponseDeliveryDTO;
import com.ananthudev.EasyCart.dto.delivery.UpdateDeliveryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService implements IDeliveryService{
    @Override
    public List<ResponseDeliveryDTO> getAllDeliveries() {
        return List.of();
    }

    @Override
    public ResponseDeliveryDTO getDeliveryById(Long id) {
        return null;
    }

    @Override
    public ResponseDeliveryDTO getDeliveryByOrderId(Long orderId) {
        return null;
    }

    @Override
    public ResponseDeliveryDTO addDelivery(CreateDeliveryDTO createDeliveryDTO) {
        return null;
    }

    @Override
    public ResponseDeliveryDTO updateDelivery(Long id, UpdateDeliveryDTO updateDeliveryDTO) {
        return null;
    }

    @Override
    public ResponseDeliveryDTO deleteDeliveryById(Long id) {
        return null;
    }
}
