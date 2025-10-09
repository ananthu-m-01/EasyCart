package com.ananthudev.EasyCart.service.order;

import com.ananthudev.EasyCart.dto.order.ResponseOrderDTO;
import com.ananthudev.EasyCart.dto.order.UpdateOrderDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IOrderService {
    List<ResponseOrderDTO> getAllOrders();
    ResponseOrderDTO getOrderById(Long id);
    ResponseOrderDTO getOrderByCustomer(Long customerId);
    ResponseOrderDTO updateOrder(Long id, UpdateOrderDTO updateOrderDTO);
    ResponseEntity<String> deleteOrderById(Long id);
}
