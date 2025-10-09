package com.ananthudev.EasyCart.controller;

import com.ananthudev.EasyCart.dto.order.ResponseOrderDTO;
import com.ananthudev.EasyCart.dto.order.UpdateOrderDTO;
import com.ananthudev.EasyCart.service.order.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    private OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<ResponseOrderDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public ResponseOrderDTO getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }


    @GetMapping("/orders/customer/{customerId}")
    public ResponseOrderDTO getOrderByCustomer(@PathVariable Long customerId){
        return orderService.getOrderByCustomer(customerId);
    }

    @PutMapping("/orders/{id}")
    public ResponseOrderDTO updateOrder(@PathVariable Long id, @RequestBody UpdateOrderDTO updateOrderDTO){
        return orderService.updateOrder(id,updateOrderDTO);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable Long id){
        return orderService.deleteOrderById(id);
    }
}
