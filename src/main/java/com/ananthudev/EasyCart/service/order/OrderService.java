package com.ananthudev.EasyCart.service.order;

import com.ananthudev.EasyCart.dto.order.ResponseOrderDTO;
import com.ananthudev.EasyCart.dto.order.UpdateOrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService{
    @Override
    public List<ResponseOrderDTO> getAllOrders() {
        return List.of();
    }

    @Override
    public ResponseOrderDTO getOrderById(Long id) {
        return null;
    }

    @Override
    public ResponseOrderDTO getOrderByCustomer(Long customerId) {
        return null;
    }

    @Override
    public ResponseOrderDTO updateOrder(Long id, UpdateOrderDTO updateOrderDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteOrderById(Long id) {
        return null;
    }
}
