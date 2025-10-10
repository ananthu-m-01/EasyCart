package com.ananthudev.EasyCart.service.delivery;

import com.ananthudev.EasyCart.dto.delivery.CreateDeliveryDTO;
import com.ananthudev.EasyCart.dto.delivery.ResponseDeliveryDTO;
import com.ananthudev.EasyCart.dto.delivery.UpdateDeliveryDTO;

import java.util.List;

public interface IDeliveryService {
    List<ResponseDeliveryDTO> getAllDeliveries();
    ResponseDeliveryDTO getDeliveryById(Long id);
    ResponseDeliveryDTO getDeliveryByOrderId(Long orderId);
    ResponseDeliveryDTO addDelivery(CreateDeliveryDTO createDeliveryDTO);
    ResponseDeliveryDTO updateDelivery(Long id, UpdateDeliveryDTO updateDeliveryDTO);
    ResponseDeliveryDTO deleteDeliveryById(Long id);
}
